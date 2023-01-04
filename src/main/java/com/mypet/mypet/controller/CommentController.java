package com.mypet.mypet.controller;


import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.service.AdoptionOfferService;
import com.mypet.mypet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;
    private final AdoptionOfferService adoptionOfferService;
    @Autowired
    public CommentController(CommentService commentService, AdoptionOfferService adoptionOfferService) {
        this.commentService = commentService;
        this.adoptionOfferService = adoptionOfferService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id) {
        Comment comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.createComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment updateComment = commentService.updateComment(comment);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable("id") Long id) {
        Comment comment = commentService.deleteCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @GetMapping("/getPostByPerson/{id}")
    public ResponseEntity<Iterable<Comment>> getCommentByPersonId(@PathVariable("id") Long id) {
        Person person = adoptionOfferService.getPersonById(id);
        Iterable<Comment> comments = commentService.getCommentByPersonId(person);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
