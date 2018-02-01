package com.company.resume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    EducationRepository newEdu;

    @Autowired
    ExperiencesRepository newExp;

    @Autowired
    SkillsRepository newSkills;


    @RequestMapping("/")
    public String listEntries(Model model) {
        model.addAttribute("basic", new basicResume());
        model.addAttribute("educations", newEdu.findAll());
        model.addAttribute("skills", newSkills.findAll());
        model.addAttribute("experiences", newExp.findAll());

        return "Main";
    }

    @GetMapping("/postform")
    public String newEntry(Model model) {
        //model.addAttribute("newPost", new Post());
        return "Form";
    }

    @PostMapping("/postform")
    public String processEntry(@Valid @ModelAttribute ("newPost") Post newPost, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Form";
        }
        model.addAttribute("newPost", newPost);
        //newBoard.save(newPost);
        return "redirect:/";
    }

}
