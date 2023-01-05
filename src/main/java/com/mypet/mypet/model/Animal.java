package com.mypet.mypet.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private int age;
    private int numDays;
    private String description;
    private List<String> images;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;
    @OneToOne(mappedBy = "animal")
    private AdoptionOffer adoptionOffer;


    public Animal(long id, String type, int age, int numDays, String description, List<String> images, Person owner, AdoptionOffer adoptionOffer) {
        this.id = id;
        this.type = type;
        this.age = age;
        this.numDays = numDays;
        this.description = description;
        this.images = images;
        this.owner = owner;
        this.adoptionOffer = adoptionOffer;
    }


    public Animal() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public AdoptionOffer getAdoptionOffer() {
        return adoptionOffer;
    }

    public void setAdoptionOffer(AdoptionOffer adoptionOffer) {
        this.adoptionOffer = adoptionOffer;
    }
}
