package com.example.SpringMVC.dao;

import com.example.SpringMVC.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
