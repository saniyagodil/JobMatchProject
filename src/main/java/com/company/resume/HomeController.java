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
    public String listEntries(Model model, @Valid @ModelAttribute ("newBasic") basicResume newBasic) {
        model.addAttribute("Basic", newBasic);
        model.addAttribute("Educations", newEdu.findAll());
        model.addAttribute("Skills", newSkills.findAll());
        model.addAttribute("Experiences", newExp.findAll());
        return "Main";
    }

    @GetMapping("/postform")
    public String newExp(Model model) {
        model.addAttribute("newExperience", new Experience());
        return "FormExp";
    }

    @GetMapping("/postform")
    public String newEdu(Model model) {
        model.addAttribute("newEducation", new Education());
        return "FormEdu";
    }

    @GetMapping("/postform")
    public String newS(Model model) {
        model.addAttribute("newSkill", new Skill());
        return "FormS";
    }


}
