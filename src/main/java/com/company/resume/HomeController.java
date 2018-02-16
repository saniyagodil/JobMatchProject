package com.company.resume;

import com.company.resume.Classes.*;
import com.company.resume.Classes.CoverLetter;
import com.company.resume.Security.User;
import com.company.resume.Security.UserService;
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

    @Autowired
    ReferenceRepository referenceRepository;

    @Autowired
    CLRepository clRepository;

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String home() {
        return "Home";
    }



    @RequestMapping("/login")
    public String login(){
        return "Login";
    }
    @GetMapping("/appregistration")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "AppRegistration";
    }

    @PostMapping("/appregistration")
    public String processUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "AppRegistration";
        }
        model.addAttribute("message", "Successfully created new applicant");
        userService.saveApplicant(user);
        return "redirect:/";

    }

    @GetMapping("/employerregistration")
    public String newEmployer(Model model){
        model.addAttribute("user", new User());
        return "AppRegistration";
    }

    @PostMapping("/employerregistration")
    public String processEmployer(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "AppRegistration";
        }
        userService.saveEmployer(user);
        return "redirect:/";

    }

    @RequestMapping("/mod")
    public String modResume(Model model){
        model.addAttribute("Basic", basicRepository.findAll());
        model.addAttribute("Educations", educationRepository.findAll());
        model.addAttribute("Skills", skillsRepository.findAll());
        model.addAttribute("Experiences", experiencesRepository.findAll());
        return "ModResume";
    }

    @RequestMapping("/resume")
    public String dispResume(Model model){
        model.addAttribute("Basic", basicRepository.findAll());
        model.addAttribute("Educations", educationRepository.findAll());
        model.addAttribute("Skills", skillsRepository.findAll());
        model.addAttribute("Experiences", experiencesRepository.findAll());
        return "Resume";
    }




////////////////////RESUME COMPONENTS

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
        return "redirect:/mod";
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
        return "redirect:/mod";
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
        return "redirect:/mod";
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
        return "redirect:/mod";
    }

    @RequestMapping("/eduupdate/{id}")
    public String updateEdu(@PathVariable("id") long id, Model model) {
        model.addAttribute("degree", educationRepository.findOne(id));
        return "FormEdu";
    }

    @RequestMapping("/edudelete/{id}")
    public String deleteEdu(@PathVariable("id") long id, Model model) {
        educationRepository.delete(id);
        return "redirect:/mod";
    }

    @RequestMapping("/expupdate/{id}")
    public String updateExp(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience", experiencesRepository.findOne(id));
        return "FormExp";
    }

    @RequestMapping("/expdelete/{id}")
    public String deleteExp(@PathVariable("id") long id, Model model) {
        experiencesRepository.delete(id);
        return "redirect:/mod";
    }
    @RequestMapping("/supdate/{id}")
    public String Supdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("skill", skillsRepository.findOne(id));
        return "FormS";
    }

    @RequestMapping("/sdelete/{id}")
    public String Sdelete(@PathVariable("id") long id, Model model) {
        skillsRepository.delete(id);
        return "redirect:/mod";
    }

/////////////////////REFERENCES
    @GetMapping("/refform")
    public String newRef(Model model) {
        model.addAttribute("reference", new Reference());
        return "RefForm";
    }
    @PostMapping("/refform")
    public String processRef(@Valid @ModelAttribute ("reference") Reference reference, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "RefForm";
        }
        model.addAttribute("reference", reference);
        referenceRepository.save(reference);
        return "redirect:/references";
    }

    @RequestMapping("/refupdate/{id}")
    public String refUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("reference", referenceRepository.findOne(id));
        return "RefForm";
    }

    @RequestMapping("/refdelete/{id}")
    public String refDelete(@PathVariable("id") long id, Model model) {
        referenceRepository.delete(id);
        return "redirect:/references";
    }

    @RequestMapping("/references")
    public String references(Model model) {
        model.addAttribute("references", referenceRepository.findAll());
        return "References";
    }

    ////////////////COVER LETTER
    @GetMapping("/clform")
    public String newCL(Model model) {
        model.addAttribute("coverletter", new CoverLetter());
        return "ClForm";
    }
    @PostMapping("/clform")
    public String processCL(@Valid @ModelAttribute ("coverletter") CoverLetter coverLetter, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ClForm";
        }
        model.addAttribute("coverLetter", coverLetter);
        clRepository.save(coverLetter);
        return "redirect:/coverletter";
    }

    @RequestMapping("/clupdate/{id}")
    public String clUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("coverletter", clRepository.findOne(id));
        return "ClForm";
    }

    @RequestMapping("/cldelete/{id}")
    public String clDelete(@PathVariable("id") long id, Model model) {
        clRepository.delete(id);
        return "redirect:/coverletter";
    }


    @RequestMapping("/coverletter")
    public String coverLetter(Model model) {
        model.addAttribute("coverletters", clRepository.findAll());
        return "CoverLetter";
    }


}
