package com.mypet.mypet.service;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.AdoptionOffer;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.repository.AdoptionOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdoptionOfferService {
    private final AdoptionOfferRepository adoptionOfferRepository;
    @Autowired
    public AdoptionOfferService(AdoptionOfferRepository adoptionOfferRepository) {
        this.adoptionOfferRepository = adoptionOfferRepository;
    }
    public AdoptionOffer getAdoptionOfferById(Long id) {
        return adoptionOfferRepository.findById(id).orElseThrow(() -> new NotFoundException("AdoptionOffer with id " + id + " was not found"));
    }
    // crud
    public AdoptionOffer createAdoptionOffer(AdoptionOffer adoptionOffer) {
        return adoptionOfferRepository.save(adoptionOffer);
    }
    public AdoptionOffer updateAdoptionOffer(AdoptionOffer adoptionOffer) {
        return adoptionOfferRepository.save(adoptionOffer);
    }
    public void deleteAdoptionOffer(Long id) {
        adoptionOfferRepository.deleteById(id);
    }

    public Iterable<AdoptionOffer> getAllAdoptionOffers() {
        return adoptionOfferRepository.findAll();
    }

    public AdoptionOffer deleteAdoptionOfferById(Long id) {
        AdoptionOffer adoptionOffer = adoptionOfferRepository.findById(id).orElseThrow(() -> new NotFoundException("AdoptionOffer with id " + id + " was not found"));
        adoptionOfferRepository.deleteById(id);
        return adoptionOffer;
    }

    public Iterable<AdoptionOffer> getAdoptionOfferByPersonId(Person person) {
        return adoptionOfferRepository.findByOwnerId(person);
    }

    public Person getPersonById(Long id) {
        return adoptionOfferRepository.findById(id).orElseThrow(() -> new NotFoundException("Person with id " + id + " was not found")).getOwner();
    }
}
