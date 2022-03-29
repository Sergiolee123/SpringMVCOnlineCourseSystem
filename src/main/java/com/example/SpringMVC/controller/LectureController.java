package com.example.SpringMVC.controller;

import com.example.SpringMVC.exception.LectureNotFindException;
import com.example.SpringMVC.exception.UserNotFindException;
import com.example.SpringMVC.model.Comment;
import com.example.SpringMVC.model.Lecture;
import com.example.SpringMVC.model.Material;
import com.example.SpringMVC.model.User;
import com.example.SpringMVC.service.CommentService;
import com.example.SpringMVC.service.LectureService;
import com.example.SpringMVC.service.MaterialService;
import com.example.SpringMVC.service.UserService;
import com.example.SpringMVC.view.DownloadingView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private LectureService lectureService;
    private UserService userService;
    private CommentService commentService;
    private MaterialService materialService;

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

    @Autowired
    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/view/{id}")
    public String lectureView(@PathVariable Long id, ModelMap map){
        Lecture lecture = lectureService.findLectureById(id).orElse(null);
        map.addAttribute("lecture", lecture);
        return "lecture";
    }

    @GetMapping("/addComment/{id}")
    public ModelAndView addCommentForm(@PathVariable Long id){
        return new ModelAndView("addComment", "comment", new Comment());
    }

    @PostMapping("/addComment/{id}")
    public String addComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment, Principal principal)
            throws UserNotFindException, LectureNotFindException {
        commentService.saveComment(id, comment, principal);
        return "redirect:/lecture/view/"+id;
    }

    @GetMapping("/material/{id}")
    public View download(@PathVariable("id") Long id){
        Optional<Material> material = materialService.findMaterialById(id);
        if(material.isPresent()){
            return new DownloadingView(material.get());
        }
        return new RedirectView("/", true);
    }

}
