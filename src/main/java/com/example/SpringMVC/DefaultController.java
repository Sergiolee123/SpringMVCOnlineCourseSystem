package com.example.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String index(ModelMap map){
        map.addAttribute("course","comps380f");
        return "index";
    }
}
