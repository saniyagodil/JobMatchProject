package com.company.resume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;


import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperiencesRepository experiencesRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    BasicRepository basicRepository;


    @RequestMapping("/")
    public String listEntries(Model model) {
        model.addAttribute("Basic", basicRepository.findAll());
        model.addAttribute("Educations", educationRepository.findAll());
        model.addAttribute("Skills", skillsRepository.findAll());
        model.addAttribute("Experiences", experiencesRepository.findAll());
        return "Main";
    }

    @GetMapping("/basicform")
    public String newBasic(Model model) {
        model.addAttribute("basic", new Basic());
        return "BasicForm";
    }

    @PostMapping("/basicform")
    public String processBasic(@Valid @ModelAttribute ("basic") Basic basic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "BasicForm";
        }
        basicRepository.save(basic);
        model.addAttribute("basic", basic);
        return "redirect:/";
    }

    @GetMapping("/expform")
    public String newExp(Model model) {
        model.addAttribute("experience", new Experience());
        return "FormExp";
    }

    @PostMapping("/expform")
    public String processExp(@Valid @ModelAttribute ("experience") Experience experience, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "FormExp";
        }
        model.addAttribute("experience", experience);
        experiencesRepository.save(experience);
        return "redirect:/";
    }


    @GetMapping("/eduform")
    public String newEdu(Model model) {
        model.addAttribute("degree", new Degree());
        return "FormEdu";
    }

    @PostMapping("/eduform")
    public String processEdu(@Valid @ModelAttribute ("degree") Degree degree, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "FormEdu";
        }
        model.addAttribute("education", degree);
        educationRepository.save(degree);
        return "redirect:/";
    }

    @GetMapping("/sform")
    public String newS(Model model) {
        model.addAttribute("skill", new Skill());
        return "FormS";
    }
    @PostMapping("/sform")
    public String processEntry(@Valid @ModelAttribute ("skill") Skill skill, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "FormS";
        }
        model.addAttribute("skill", skill);
        skillsRepository.save(skill);
        return "redirect:/";
    }

}
