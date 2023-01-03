package com.mypet.mypet.service;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person with id " + id + " was not found"));
    }
    // crud
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
   public Person deletePersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person with id " + id + " was not found"));
        personRepository.deleteById(id);
        return person;
    }

}
