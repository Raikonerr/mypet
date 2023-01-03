package com.mypet.mypet.repository;

import com.mypet.mypet.model.AdoptionOffer;
import com.mypet.mypet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionOfferRepository extends JpaRepository<AdoptionOffer, Long> {

    Iterable<AdoptionOffer> findByPersonId(Person person);
}

