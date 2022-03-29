package com.example.SpringMVC.controller;

import com.example.SpringMVC.exception.PollNotFoundException;
import com.example.SpringMVC.exception.UserNotFindException;
import com.example.SpringMVC.service.PollResultService;
import com.example.SpringMVC.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/poll")
public class PollController {

    private PollService pollService;
    private PollResultService pollResultService;

    @Autowired
    public void setPollService(PollService pollService) {
        this.pollService = pollService;
    }

    @Autowired
    public void setPollResultService(PollResultService pollResultService) {
        this.pollResultService = pollResultService;
    }

    @GetMapping("/view/{id}")
    public String pollView(@PathVariable Long id, ModelMap map){
        map.addAttribute("poll", pollService.findPollById(id).orElse(null));
        return "Poll";
    }

    @GetMapping("/submit/{pollId}/{option}")
    public String pollSubmit(@PathVariable("pollId") Long pollId,
                             @PathVariable("option") String option, Principal principal)
            throws PollNotFoundException, UserNotFindException {
        //prevent invalid data
        if(Pattern.matches("A-D", option)){
            pollResultService.addPollResult(pollId, option, principal);
        }
        return "redirect:/poll/view/"+pollId;
    }
}
