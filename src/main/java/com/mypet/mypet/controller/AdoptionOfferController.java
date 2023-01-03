package com.mypet.mypet.controller;

import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.AdoptionOffer;
import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.service.AdoptionOfferService;
import com.mypet.mypet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adoptionOffer")
public class AdoptionOfferController {
    private final AdoptionOfferService adoptionOfferService;
    private final PersonService personService;
    @Autowired
    public AdoptionOfferController(AdoptionOfferService adoptionOfferService, PersonService personService) {
        this.adoptionOfferService = adoptionOfferService;
        this.personService = personService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<AdoptionOffer>> getAllAdoptionOffers() {
        Iterable<AdoptionOffer> adoptionOffers = adoptionOfferService.getAllAdoptionOffers();
        return new ResponseEntity<>(adoptionOffers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdoptionOffer> getAdoptionOfferById(@PathVariable("id") Long id) {
        AdoptionOffer adoptionOffer = adoptionOfferService.getAdoptionOfferById(id);
        return new ResponseEntity<>(adoptionOffer, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<AdoptionOffer> addAdoptionOffer(@RequestBody AdoptionOffer adoptionOffer) {
        AdoptionOffer newAdoptionOffer = adoptionOfferService.createAdoptionOffer(adoptionOffer);
        return new ResponseEntity<>(newAdoptionOffer, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<AdoptionOffer> updateAdoptionOffer(@RequestBody AdoptionOffer adoptionOffer) {
        AdoptionOffer updateAdoptionOffer = adoptionOfferService.updateAdoptionOffer(adoptionOffer);
        return new ResponseEntity<>(updateAdoptionOffer, HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteAdoptionOffer(@PathVariable("id") Long id) {
        adoptionOfferService.deleteAdoptionOffer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<AdoptionOffer> deleteAdoptionOfferById(@PathVariable("id") Long id) {
        AdoptionOffer adoptionOffer = adoptionOfferService.deleteAdoptionOfferById(id);
        return new ResponseEntity<>(adoptionOffer, HttpStatus.OK);
    }
    @GetMapping("/getPostByPerson/{id}")
    public ResponseEntity<Iterable<AdoptionOffer>> getAdoptionOfferByPersonId(@PathVariable("id") Long id) {
        Person person = personService.getPersonById(id);
        Iterable<AdoptionOffer> adoptionOffers = adoptionOfferService.getAdoptionOfferByPersonId(person);
        return new ResponseEntity<>(adoptionOffers, HttpStatus.OK);
    }

}
