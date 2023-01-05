package com.mypet.mypet.controller;


import com.mypet.mypet.model.Comment;
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
        try{
            return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Comment could not be created");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment updateComment, @PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        try{
            comment.setAdoptionOffer(updateComment.getAdoptionOffer());
            comment.setReplies(updateComment.getReplies());
            comment.setText();
            return new ResponseEntity<>(commentService.updateComment(comment), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Comment could not be updated");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        try{
            commentService.deleteCommentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            throw new RuntimeException("Comment could not be deleted");
        }
    }

}
