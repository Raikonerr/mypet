package com.mypet.mypet.controller;

import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Reply;
import com.mypet.mypet.repository.CommentRepository;
import com.mypet.mypet.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public ReplyController(ReplyRepository replyRepository, CommentRepository commentRepository) {
        this.replyRepository = replyRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping()
    public Iterable<Reply> getAllReplies() {
        return replyRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Reply> getReplyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(replyRepository.findById(id), HttpStatus.OK).getBody();
    }

    @PostMapping()
    public ResponseEntity<Reply> addReply(@RequestBody Reply reply) {
        try{
            return new ResponseEntity<>(replyRepository.save(reply), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Reply could not be created");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reply> updateReply(@RequestBody Reply updateReply, @PathVariable Long id) {
        Reply reply = replyRepository.findById(id).get();
        try{
            reply.setComment(updateReply.getComment());
            reply.setText(updateReply.getText());
            return new ResponseEntity<>(replyRepository.save(reply), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Reply could not be updated");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Reply> deleteReply(@PathVariable Long id) {
        Reply reply = replyRepository.findById(id).get();
        try{
            replyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            throw new RuntimeException("Reply could not be deleted");
        }
    }

}
