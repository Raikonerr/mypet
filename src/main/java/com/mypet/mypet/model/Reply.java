package com.mypet.mypet.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    @ManyToOne
    private AdoptionOffer adoptionOffer;
    @ManyToOne
    private Reply replies;

    @ManyToOne
    private Comment comments;

    public Comment getComment() {
        return comments;
    }

    public void setComment(Comment comment) {
        this.comments = comment;
    }

    public Reply(long id, String text, AdoptionOffer adoptionOffer, Reply replies) {
        this.id = id;
        this.text = text;
        this.adoptionOffer = adoptionOffer;
        this.replies = replies;
    }

    public Reply() {
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

    public Reply getReplies() {
        return replies;
    }

    public void setReplies(Reply replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return id == reply.id && Objects.equals(text, reply.text) && Objects.equals(adoptionOffer, reply.adoptionOffer) && Objects.equals(replies, reply.replies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, adoptionOffer, replies);
    }
}
