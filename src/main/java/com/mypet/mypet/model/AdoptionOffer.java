package com.mypet.mypet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdoptionOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String city;
    private String type;
    private int numDays;
    private List<String> images;
    private float price;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;
    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @OneToMany(mappedBy = "adoptionOffer")
    private List<Comment> comments;


    public AdoptionOffer() {
    }

    public AdoptionOffer(long id, String title, String description, String city, String type, int numDays, List<String> images, float price, Person owner, Animal animal, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.type = type;
        this.numDays = numDays;
        this.images = images;
        this.price = price;
        this.owner = owner;
        this.animal = animal;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
