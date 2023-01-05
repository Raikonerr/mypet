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
    public Iterable<AdoptionOffer> getAllAdoptionOffers(){
        Iterable<AdoptionOffer> adoptionOffers = adoptionOfferService.getAllAdoptionOffers();
        return ResponseEntity.ok(adoptionOffers).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionOffer> getAdoptionOfferById(@PathVariable("id") Long id){
        try{
            AdoptionOffer adoptionOffer = adoptionOfferService.getAdoptionOfferById(id);
            return ResponseEntity.ok(adoptionOffer);
        }catch (NotFoundException e){
            throw new NotFoundException("AdoptionOffer with id " + id + " was not found");
        }
    }

    @PostMapping()
    public ResponseEntity<AdoptionOffer> addAdoptionOffer(@RequestBody AdoptionOffer adoptionOffer){
        try{
            return new ResponseEntity<>(adoptionOfferService.createAdoptionOffer(adoptionOffer), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("AdoptionOffer could not be created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdoptionOffer> updateAdoptionOffer(@RequestBody AdoptionOffer updateAdoptionOffer, @PathVariable Long id){
        try{
            AdoptionOffer adoptionOffer = adoptionOfferService.getAdoptionOfferById(id);
            try{
                adoptionOffer.setOwner(updateAdoptionOffer.getOwner());
                adoptionOffer.setAnimal(updateAdoptionOffer.getAnimal());
                adoptionOffer.setComments(updateAdoptionOffer.getComments());
                adoptionOffer.setNumDays(updateAdoptionOffer.getNumDays());
                adoptionOffer.setCity(updateAdoptionOffer.getCity());
                adoptionOffer.setDescription(updateAdoptionOffer.getDescription());
                adoptionOffer.setPrice(updateAdoptionOffer.getPrice());
                adoptionOffer.setImages(updateAdoptionOffer.getImages());
                adoptionOffer.setTitle(updateAdoptionOffer.getTitle());
                adoptionOffer.setType(updateAdoptionOffer.getType());
                return new ResponseEntity<>(adoptionOfferService.updateAdoptionOffer(adoptionOffer), HttpStatus.OK);
            }catch (Exception e){
                throw new RuntimeException("AdoptionOffer could not be updated");
            }
        }catch (NotFoundException e){
            throw new NotFoundException("AdoptionOffer with id " + id + " was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdoptionOffer> deleteAdoptionOffer(@PathVariable Long id){
        try{
            AdoptionOffer adoptionOffer = adoptionOfferService.getAdoptionOfferById(id);
            try{
                adoptionOfferService.deleteAdoptionOffer(id);
                return new ResponseEntity<>(adoptionOffer, HttpStatus.OK);
            }catch (Exception e){
                throw new RuntimeException("AdoptionOffer could not be deleted");
            }
        }catch (NotFoundException e){
            throw new NotFoundException("AdoptionOffer with id " + id + " was not found");
        }
    }



}
