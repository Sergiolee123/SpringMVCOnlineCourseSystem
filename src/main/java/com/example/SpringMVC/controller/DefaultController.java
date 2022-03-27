package com.example.SpringMVC.controller;

import com.example.SpringMVC.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private LectureService lectureService;

    @Autowired
    public void setService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/")
    public String index(ModelMap map){
        map.addAttribute("course","comps380f");
        map.addAttribute("lectures", lectureService.findAllLectures());
        return "index";
    }

}
