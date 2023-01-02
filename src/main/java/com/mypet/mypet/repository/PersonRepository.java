package com.mypet.mypet.repository;

import com.mypet.mypet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByLogin(String login);
    Person findByEmail(String email);
}

