package com.mypet.mypet.repository;
import com.mypet.mypet.model.Comment;
import com.mypet.mypet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Iterable<Comment> findByPerson(Person person);
}
