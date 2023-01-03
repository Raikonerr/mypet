package com.mypet.mypet.service;

import com.mypet.mypet.exception.BadRequestException;
import com.mypet.mypet.exception.NotFoundException;
import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Reply;
import com.mypet.mypet.repository.CommentRepository;
import com.mypet.mypet.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public ReplyService(ReplyRepository replyRepository, CommentRepository commentRepository) {
        this.replyRepository = replyRepository;
        this.commentRepository = commentRepository;
    }
    public Reply getReplyById(Long id) {
        return replyRepository.findById(id).orElseThrow(() -> new NotFoundException("Reply with id " + id + " was not found"));
    }
    // crud
    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }
    public Reply updateReply(Reply reply) {
        return replyRepository.save(reply);
    }
    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }
    public Reply deleteReplyById(Long id) {
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new NotFoundException("Reply with id " + id + " was not found"));
        replyRepository.deleteById(id);
        return reply;
    }
    // if i delete a reply, i also delete it from the comment
    public void deleteReplyAndComment(Long id) {
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new NotFoundException("Reply with id " + id + " was not found"));
        replyRepository.deleteById(id);
        Comment comment = reply.getComment();
        comment.getReplies().remove(reply);
        commentRepository.save(comment);
    }
}
