package com.mypet.mypet.controller;

import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Animal;
import com.mypet.mypet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Animal getAnimalById(@PathVariable("id") Long id) {
        return animalService.getAnimalById(id);
    }
    @PostMapping()
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }
    @PutMapping()
    public Animal updateAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }
    @DeleteMapping()
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimal(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public Animal deleteAnimalById(@PathVariable("id") Long id) {
        return animalService.deleteAnimalById(id);
    }
}
