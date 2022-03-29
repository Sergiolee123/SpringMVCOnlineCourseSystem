package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.CommentRepository;
import com.example.SpringMVC.dao.LectureRepository;
import com.example.SpringMVC.dao.UserRepository;
import com.example.SpringMVC.exception.CommentNotFoundException;
import com.example.SpringMVC.exception.LectureNotFindException;
import com.example.SpringMVC.exception.UserNotFindException;
import com.example.SpringMVC.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Date;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private LectureRepository lectureRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLectureRepository(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void saveComment(Long id, Comment comment, Principal principal)
            throws UserNotFindException, LectureNotFindException {
        comment.setDate(new Date());
        comment.setUser(userRepository.findById(principal.getName()).orElseThrow(UserNotFindException::new));
        comment.setLecture(lectureRepository.findById(id).orElseThrow(LectureNotFindException::new));
        commentRepository.save(comment);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void updateCommentById(Long id, Comment comment) throws CommentNotFoundException {
        Comment toUpdateComment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        toUpdateComment.setContent(comment.getContent());
        commentRepository.save(toUpdateComment);
    }
}
