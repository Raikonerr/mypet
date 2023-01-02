package com.mypet.mypet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    private String address;
    private String email;
    private String telephone;
    private int numAnimals;
    @OneToMany(mappedBy = "owner")
    private List<AdoptionOffer> adoptionOffers;


    public Person(String login) {
        this.login = login;
    }


    public Person(long id, String login, String password, String address, String email, String telephone, int numAnimals, List<AdoptionOffer> adoptionOffers) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.numAnimals = numAnimals;
        this.adoptionOffers = adoptionOffers;
    }

    public Person() {

    }
}
