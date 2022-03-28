package com.example.SpringMVC.controller;

import com.example.SpringMVC.model.Comment;
import com.example.SpringMVC.model.Lecture;
import com.example.SpringMVC.service.CommentService;
import com.example.SpringMVC.service.LectureService;
import com.example.SpringMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private LectureService lectureService;
    private UserService userService;
    private CommentService commentService;

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/view/{id}")
    public String lectureView(@PathVariable Long id, ModelMap map){
        map.addAttribute("lecture", lectureService.findLectureById(id));
        return "lecture";
    }

    @GetMapping("/addComment/{id}")
    public ModelAndView addCommentForm(@PathVariable Long id){
        return new ModelAndView("addComment", "comment", new Comment());
    }

    @PostMapping("/addComment/{id}")
    public String addComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment, Principal principal){
        comment.setLecture(lectureService.findLectureById(id));
        comment.setUser(userService.findUserByUserName(principal.getName()));
        comment.setDate(new Date());
        commentService.saveComment(comment);
        return "redirect:/lecture/view/"+id;
    }

}
