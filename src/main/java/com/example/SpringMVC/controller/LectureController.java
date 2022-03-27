package com.example.SpringMVC.controller;

import com.example.SpringMVC.model.Comment;
import com.example.SpringMVC.model.Lecture;
import com.example.SpringMVC.service.LectureService;
import com.example.SpringMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private LectureService lectureService;
    private UserService userService;

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/view/{id}")
    public String lectureView(@PathVariable Long id, ModelMap map){
        map.addAttribute("lecture", lectureService.findLectureById(id));
        return "lecture";
    }

    @GetMapping("/addComment/{id}")
    public ModelAndView addCommentForm(@PathVariable Long id, Principal principal){
        Comment comment = new Comment();
        comment.setLecture(lectureService.findLectureById(id));
        comment.setUser(userService.findUserByUserName(principal.getName()));
        return new ModelAndView("addComment", "comment", comment);
    }

    @PutMapping("/addComment")
    public String addComment(@ModelAttribute("comment") Comment comment){

        return "redirect:/";
    }

}
