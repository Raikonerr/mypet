package com.mypet.mypet.service;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Animal;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService
{
    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository)
    {
        this.animalRepository = animalRepository;
    }
    public Animal getAnimalById(Long id)
    {
        return animalRepository.findById(id).orElseThrow(() -> new NotFoundException("Animal with id " + id + " was not found"));
    }
    // crud
    public Animal createAnimal(Animal animal)
    {
        return animalRepository.save(animal);
    }
    public Animal updateAnimal(Animal animal)
    {
        return animalRepository.save(animal);
    }
    public void deleteAnimal(Long id)
    {
        animalRepository.deleteById(id);
    }
    public Animal deleteAnimalById(Long id)
    {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new NotFoundException("Animal with id " + id + " was not found"));
        animalRepository.deleteById(id);
        return animal;
    }

    public Iterable<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
}
