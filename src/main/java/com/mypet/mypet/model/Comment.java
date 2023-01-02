package com.mypet.mypet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String text;
    @ManyToOne
    private AdoptionOffer adoptionOffer;
    @OneToMany(mappedBy = "comments")
    private List<Reply> replies;

    public Comment(long id, String text, AdoptionOffer adoptionOffer, List<Reply> replies) {
        this.id = id;
        this.text = text;
        this.adoptionOffer = adoptionOffer;
        this.replies = replies;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AdoptionOffer getAdoptionOffer() {
        return adoptionOffer;
    }

    public void setAdoptionOffer(AdoptionOffer adoptionOffer) {
        this.adoptionOffer = adoptionOffer;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
