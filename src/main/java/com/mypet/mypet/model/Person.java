package com.mypet.mypet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private int numAnimals;
    @OneToMany(mappedBy = "owner")
    private List<AdoptionOffer> adoptionOffers;


    public Person(String login) {
        this.login = login;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNumAnimals() {
        return numAnimals;
    }

    public void setNumAnimals(int numAnimals) {
        this.numAnimals = numAnimals;
    }

    public List<AdoptionOffer> getAdoptionOffers() {
        return adoptionOffers;
    }

    public void setAdoptionOffers(List<AdoptionOffer> adoptionOffers) {
        this.adoptionOffers = adoptionOffers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
