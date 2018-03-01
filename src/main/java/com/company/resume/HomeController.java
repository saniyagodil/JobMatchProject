package com.company.resume;

import com.company.resume.Models.*;
import com.company.resume.Models.User;
import com.company.resume.Repositories.*;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BasicRepository basicRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperiencesRepository experiencesRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    CLRepository clRepository;
    @Autowired
    ReferenceRepository referenceRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    OrganizationRepository organizationRepository;

////Everyone///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/")
    public String home() {
        return "Home";
    }

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/applicantregistration")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "ApplicantRegistration";
    }

    @PostMapping("/applicantregistration")
    public String processUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "ApplicantRegistration";
        }
        model.addAttribute("message", "Successfully created new applicant");
        user.addRole(roleRepository.findRoleByRoleName("APPLICANT"));
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/employerregistration")
    public String newEmployer(Model model){
        model.addAttribute("user", new User());
        return "EmployerRegistration";
    }

    @PostMapping("/employerregistration")
    public String processEmployer(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "EmployerRegistration";
        }
        user.addRole(roleRepository.findRoleByRoleName("EMPLOYER"));
        userRepository.save(user);
        return "redirect:/";
    }


////Applicant///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/mod")
    public String modResume(Model model, Authentication auth){
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("Basic", basicRepository.findAll());
        model.addAttribute("Educations", educationRepository.findAll());
        model.addAttribute("Skills", skillsRepository.findAll());
        model.addAttribute("Experiences", experiencesRepository.findAll());
        return "ModResume";
    }

    @RequestMapping("/resume")
    public String displayResume(Model model, Authentication auth){
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("Basic", basicRepository.findAll());
        model.addAttribute("Educations", educationRepository.findAll());
        model.addAttribute("Skills", skillsRepository.findAll());
        model.addAttribute("Experiences", experiencesRepository.findAll());
        return "Resume";
    }

    @RequestMapping("/coverletter")
    public String coverLetter(Model model, Authentication auth) {
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("coverletters", clRepository.findAll());
        return "CoverLetter";
    }

    @RequestMapping("/references")
    public String references(Model model, Authentication auth) {
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("references", referenceRepository.findAll());
        return "References";
    }

                        //////////////////RESUME COMPONENTS////////////////////////

    @GetMapping("/basicform")
    public String newBasic(Model model) {
        model.addAttribute("basic", new Basic());
        return "BasicForm";
    }

    @PostMapping("/basicform")
    public String processBasic(Authentication auth, @Valid @ModelAttribute ("basic") Basic basic, BindingResult result) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "BasicForm";
        }
        basicRepository.save(basic);
        user.getBasics().toString();
        user.addBasic(basic);
        userRepository.save(user);
        return "redirect:/mod";
    }

    @GetMapping("/expform")
    public String newExp(Model model) {
        model.addAttribute("experience", new Experience());
        return "FormExp";
    }

    @PostMapping("/expform")
    public String processExp(Authentication auth, @Valid @ModelAttribute ("experience") Experience experience, BindingResult result, Model model) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "FormExp";
        }
        experiencesRepository.save(experience);
        user.getExperiences().toString();
        user.addExperience(experience);
        userRepository.save(user);
        return "redirect:/mod";
    }

    @GetMapping("/eduform")
    public String newEdu(Model model) {
        model.addAttribute("degree", new Degree());
        return "FormEdu";
    }

    @PostMapping("/eduform")
    public String processEdu(Authentication auth, @Valid @ModelAttribute ("degree") Degree degree, BindingResult result, Model model) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "FormEdu";
        }
        educationRepository.save(degree);
        user.getDegrees().toString();
        user.addEducation(degree);
        userRepository.save(user);
        return "redirect:/mod";
    }

    @GetMapping("/sform")
    public String newS(Model model) {
        model.addAttribute("skill", new Skill());
        return "SkillForm";
    }

    @PostMapping("/sform")
    public String processEntry(Authentication auth, @Valid @ModelAttribute ("skill") Skill skill, BindingResult result, Model model) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "SkillForm";
        }
        skillsRepository.save(skill);
        user.getSkills().toString();
        user.addSkill(skill);
        userRepository.save(user);
        return "redirect:/mod";
    }

    @GetMapping("/refform")
    public String newRef(Model model) {
        model.addAttribute("reference", new Reference());
        return "RefForm";
    }

    @PostMapping("/refform")
    public String processRef(Authentication auth, @Valid @ModelAttribute ("reference") Reference reference, BindingResult result, Model model) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "RefForm";
        }
        referenceRepository.save(reference);
        user.getReferences().toString();
        user.addReference(reference);
        userRepository.save(user);
        return "redirect:/references";
    }

    @GetMapping("/clform")
    public String newCL(Model model) {
        model.addAttribute("coverletter", new CoverLetter());
        return "ClForm";
    }

    @PostMapping("/clform")
    public String processCL(Authentication auth, @Valid @ModelAttribute ("coverletter") CoverLetter coverLetter, BindingResult result, Model model) {
        User user = userRepository.findByUsername(auth.getName());
        if (result.hasErrors()) {
            return "ClForm";
        }
        clRepository.save(coverLetter);
        user.getCoverLetters().toString();
        user.addCoverLetter(coverLetter);
        userRepository.save(user);
        return "redirect:/coverletter";
    }

                         //////////////////Update/Detail Resume Components///////////////////

    @RequestMapping("/basicupdate/{id}")
    public String updateBasic(@PathVariable("id") long id, Model model) {
        model.addAttribute("basic", basicRepository.findOne(id));
        return "BasicForm";
    }

    @RequestMapping("/basicdelete/{id}")
    public String deleteBasic(@PathVariable("id") long id, Model model) {
        basicRepository.delete(id);
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
        return "SkillForm";
    }

    @RequestMapping("/sdelete/{id}")
    public String Sdelete(@PathVariable("id") long id, Model model) {
        skillsRepository.delete(id);
        return "redirect:/mod";
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


////////////////////////////////////////////////////////

//    @RequestMapping("/job/{id}")
//    public String findCandidates(@PathVariable("id") long id, Model model){
//        Job job = jobRepository.findOne(id);
//        Collection<Skill> skills = job.getSkills();
//        Collection<Resume> resumes = resumeRepository.findAllResumeBySkillsContaining(skills);
//
//        return "JobListings";
//    }



    @RequestMapping("/getMyJobs")
    public String getJobsThatApply(Authentication auth, Model model){
        HashSet<Skill> mySkills = new HashSet(userRepository.findByUsername(auth.getName()).getSkills());
        HashSet <Job> matchingJobs = new HashSet<>();
        model.addAttribute("jobs", jobRepository.findAllByJobSkillsContains(mySkills));
        return "viewsuggestedjobs";
    }

    @RequestMapping("/applyjob/{id}")
    public String applyForJob(@PathVariable("id") long id, Model model, Authentication auth){
        User user = userRepository.findByUsername(auth.getName());
        Job job = jobRepository.findOne(id);
        job.addApplicant(user);
        jobRepository.save(job);
        return "redirect:/getMyJobs";
    }






////Employer and Recruiter/////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/addorganization")
    public String newOrganization(Model model){
        model.addAttribute("organization", new Organization());
        return "OrganizationForm";
    }

    @PostMapping("/addorganization")
    public String processOrganization(@Valid@ModelAttribute("organization") Organization organization, BindingResult result, Authentication auth){
        if(result.hasErrors()){
            return "OrganizationForm";
        }
        organizationRepository.save(organization);
        User user = userRepository.findByUsername(auth.getName());
        user.setOrganization(organization.getOrganizationName());
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping("/viewjobs")
    public String viewJobs(Authentication auth, Model model){
        User user = userRepository.findByUsername(auth.getName());
        String org = user.getOrganization();
        model.addAttribute("jobs", jobRepository.findByJobOrg(org));
        return "AllJobs";
    }

    @GetMapping("/job/{id}") /// id-> job
    public String viewUserJob(Authentication auth, Model model, @PathVariable("id") long id){
        Job job = jobRepository.findOne(id);
        model.addAttribute("job", job);
        User user = userRepository.findByUsername(auth.getName());
        Set<Role> roles = user.getRoles();

        for(Role thisRole: roles){
            if(thisRole.getRoleName().equalsIgnoreCase("RECRUITER")){
                model.addAttribute("applicants", job.getApplied());
                model.addAttribute("shortlisters", job.getShortlist());
            } else if(thisRole.getRoleName().equalsIgnoreCase("EMPLOYER")){
                model.addAttribute("shortlisters", job.getShortlist());
            }
        }
        return "JobView";
    }

    @RequestMapping("/job/{id}") ///id-> user who has applied
    public String addUserToShortList(@Valid@ModelAttribute("job") Job job, @PathVariable("id") long id){
        job.addToShortlist(userRepository.findOne(id));
        jobRepository.save(job);
        return "redirect:/alljobs";
    }

////Employer///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/recruiterregistration")
    public String newRecruiter(Model model, Authentication auth){
        User user = userRepository.findByUsername(auth.getName());
        model.addAttribute("organization", user.getOrganization());
        model.addAttribute("user", new User());
        return "RecruiterRegistration";
    }

    @PostMapping("/recruiterregistration")
    public String processRecruiter(@Valid @ModelAttribute("user") User user, @Valid@ModelAttribute("organization") String organization, BindingResult result, Model model){
        if(result.hasErrors()){
            return "RecruiterRegistration";
        }
        user.setOrganization(organization);
        user.addRole(roleRepository.findRoleByRoleName("RECRUITER"));
        userRepository.save(user);
        return "redirect:/";
    }

////Recruiter///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/addjob")
    public String newJob(Model model){
        model.addAttribute("job", new Job());
        return "JobForm";
    }

    @PostMapping("/addjob")
    public String processJob(@Valid@ModelAttribute("job") Job job, BindingResult result){
        if(result.hasErrors()){
            return "JobForm";
        }
        jobRepository.save(job);
        return "redirect:/";
    }

    @GetMapping("/addskilltojob/{id}")
    public String addSkilltoJob(@PathVariable("id") long id, Model model){
        Job job = jobRepository.findOne(id);
        model.addAttribute("job", job);
        model.addAttribute("skill", new Skill());
        return "SkillToJobForm";
    }

    @PostMapping("/addskilltojob/{id}")
    public String processSkilltoJob(@Valid @ModelAttribute("skill") Skill skill, @Valid @ModelAttribute("job") Job job, BindingResult result){
        if (result.hasErrors()){
            return "SkillToJobForm";
        }
        job.addSkilltoJob(skill);
        skillsRepository.save(skill);
        jobRepository.save(job);
        return "redirect:/alljobs";
    }


    @RequestMapping("/jobupdate/{id}")
    public String updateJob(@PathVariable("id") long id, Model model){
        model.addAttribute("job", jobRepository.findOne(id));
       return "JobForm";
    }

    @RequestMapping("/jobdelete/{id}")
    public String deleteJob(@PathVariable("id") long id, Model model){
        jobRepository.delete(id);
        return "redirect:/alljobs";
    }

}
