package com.example.SpringMVC.controller;

import com.example.SpringMVC.dao.LectureRepository;
import com.example.SpringMVC.model.Lecture;
import com.example.SpringMVC.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lecture/edit")
public class EditLectureController {

    private LectureService lectureService;

    @Autowired
    public void setLectureRepository(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/addLecture")
    public ModelAndView addLectureForm(){
        return new ModelAndView("addLecture", "lecture", new Lecture());
    }

    @PostMapping("/addLecture")
    public String addLecture(@ModelAttribute("lecture") Lecture lecture){
        lectureService.saveLecture(lecture);
        return "redirect:/";
    }
}
