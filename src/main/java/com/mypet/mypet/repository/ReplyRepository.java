package com.mypet.mypet.repository;


import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    Iterable<Reply> findByComments(Comment comment);
}

