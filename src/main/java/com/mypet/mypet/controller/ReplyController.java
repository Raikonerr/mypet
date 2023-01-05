package com.mypet.mypet.controller;

import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Reply;
import com.mypet.mypet.repository.CommentRepository;
import com.mypet.mypet.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return replyRepository.findById(id);
    }
    @PostMapping()
    public Reply addReply(@RequestBody Reply reply) {
        return replyRepository.save(reply);
    }
    @PutMapping()
    public Reply updateReply(@RequestBody Reply reply) {
        return replyRepository.save(reply);
    }
    @DeleteMapping("/{id}")
    public void deleteReplyById(@PathVariable("id") Long id) {
        replyRepository.deleteById(id);
    }
    @GetMapping("/getReplyByComment/{id}")
    public Iterable<Reply> getReplyByCommentId(@PathVariable("id") Long id) {
        Comment comment = commentRepository.findById(id).get();
        return replyRepository.findByComments(comment);
    }
}
