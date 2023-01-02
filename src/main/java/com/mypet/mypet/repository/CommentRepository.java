package com.mypet.mypet.repository;
import com.mypet.mypet.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
