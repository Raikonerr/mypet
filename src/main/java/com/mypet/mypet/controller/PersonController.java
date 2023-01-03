package com.mypet.mypet.controller;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping()
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = personService.createPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long id) {
        Person person = personService.deletePersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}
