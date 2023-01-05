package com.mypet.mypet.controller;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Animal;
import com.mypet.mypet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public Iterable<Animal> getAllAnimals() {
        Iterable<Animal> animals = animalService.getAllAnimals();
        return ResponseEntity.ok(animals).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Long id) {
        try {
            Animal animal = animalService.getAnimalById(id);
            return ResponseEntity.ok(animal);
        } catch (NotFoundException e) {
            throw new NotFoundException("Animal with id " + id + " was not found");
        }
    }

    @PostMapping()
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        try {
            return new ResponseEntity<>(animalService.createAnimal(animal), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Animal could not be created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal updateAnimal, @PathVariable Long id) {
        try {
            Animal animal = animalService.getAnimalById(id);
            try {
                animal.setAge(updateAnimal.getAge());
                animal.setType(updateAnimal.getType());
                animal.setDescription(updateAnimal.getDescription());
                animal.setImages(updateAnimal.getImages());
                animal.setOwner(updateAnimal.getOwner());
                animal.setAdoptionOffer(updateAnimal.getAdoptionOffer());
                animal.setNumDays(updateAnimal.getNumDays());
                return new ResponseEntity<>(animalService.updateAnimal(animal), HttpStatus.OK);
            } catch (Exception e) {
                throw new RuntimeException("Animal could not be updated");
            }
        } catch (NotFoundException e) {
            throw new NotFoundException("Animal with id " + id + " was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> deleteAnimalById(@PathVariable("id") Long id) {
        try {
             animalService.getAnimalById(id);

            try{
            Animal animal =  animalService.deleteAnimalById(id);
            return new ResponseEntity<>(animal, HttpStatus.OK);

        } catch (NotFoundException e) {
            throw new BadRequestException("Animal with id " + id + " could not be deleted");
        }
    }catch (NotFoundException e) {
            throw new NotFoundException("Animal with id " + id + " was not found");
        }
    }
}
