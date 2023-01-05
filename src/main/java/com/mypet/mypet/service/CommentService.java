package com.mypet.mypet.service;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Person;
import com.mypet.mypet.repository.CommentRepository;
import com.mypet.mypet.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, ReplyRepository replyRepository) {
        this.commentRepository = commentRepository;
        this.replyRepository = replyRepository;
    }
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment with id " + id + " was not found"));
    }
    // crud
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    public Comment deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment with id " + id + " was not found"));
        commentRepository.deleteById(id);
        return comment;
    }

    // if i delete a comment, i also delete all replies
    public void deleteCommentAndReplies(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment with id " + id + " was not found"));
        commentRepository.deleteById(id);
        replyRepository.deleteAll(comment.getReplies());
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

}
