package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Comment;
import com.assignment.entity.User;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostedByUser(User user);
}

