package com.mypet.mypet.repository;

import com.mypet.mypet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
