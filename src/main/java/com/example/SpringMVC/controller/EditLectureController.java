package com.example.SpringMVC.controller;

import com.example.SpringMVC.dao.LectureRepository;
import com.example.SpringMVC.model.AddMaterialForm;
import com.example.SpringMVC.model.Lecture;
import com.example.SpringMVC.model.Material;
import com.example.SpringMVC.service.LectureService;
import com.example.SpringMVC.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/lecture/edit")
public class EditLectureController {

    private LectureService lectureService;
    private MaterialService materialService;

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Autowired
    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
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

    @GetMapping("/uploadMaterial/{id}")
    public ModelAndView addMaterial(@PathVariable Long id){
        return new ModelAndView("addMaterial", "material", new AddMaterialForm());
    }

    @PostMapping("/uploadMaterial/{id}")
    public String addMaterial(@PathVariable Long id, AddMaterialForm addMaterialForm, Principal principal) throws IOException {
        for(MultipartFile file: addMaterialForm.getAttachments()){
            Material material = new Material();
            material.setOwner_username(principal.getName());
            material.setLecture(lectureService.findLectureById(id));
            material.setMaterialName(file.getOriginalFilename());
            material.setContents(file.getBytes());
            material.setMimeContentType(file.getContentType());
            material.setDate(new Date());
            materialService.addMaterial(material);
        }
        return "redirect:/lecture/view/"+id;
    }
}
