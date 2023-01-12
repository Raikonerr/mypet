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
@CrossOrigin("*")
public class PersonController {
    @Autowired
    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping()
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(personService.getPersonById(Long.valueOf(id)), HttpStatus.OK);
        }catch(Exception e){
            throw new NotFoundException("There is no person with id : " + id);
        }
    }
    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        /*try{
            return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }*/
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person updatePerson,@PathVariable Integer id) {
        try{
        Person person = personService.getPersonById(Long.valueOf(id));
        try{
            person.setAddress(updatePerson.getAddress());
            person.setEmail(updatePerson.getEmail());
            person.setPassword(updatePerson.getPassword());
            person.setLogin(updatePerson.getLogin());
            person.setTelephone(updatePerson.getTelephone());
            person.setNumAnimals(updatePerson.getNumAnimals());
            person.setAdoptionOffers(updatePerson.getAdoptionOffers());
            return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }}catch (Exception e){
            throw new NotFoundException("There is no person with id : " + id);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id){
        try{
            //find the person
            personService.getPersonById(Long.valueOf(id));
            try {
                //delete the person
                personService.deletePerson(Long.valueOf(id));
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                throw new BadRequestException("Something wrong in the form or values of the required data");
            }
        }catch(Exception e){
            throw new NotFoundException("There is no person with id : " + id);
        }
    }
}
