package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.CommentRepository;
import com.example.SpringMVC.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
}
