package com.company.resume.Security;

import com.company.resume.Models.*;
import com.company.resume.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

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
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BasicRepository basicRepository, SkillsRepository skillsRepository, EducationRepository educationRepository, ExperiencesRepository experiencesRepository, CLRepository clRepository, ReferenceRepository referenceRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.basicRepository = basicRepository;
        this.educationRepository = educationRepository;
        this.experiencesRepository = experiencesRepository;
        this.skillsRepository = skillsRepository;
        this.referenceRepository = referenceRepository;
        this.clRepository = clRepository;
    }

    public UserService() {
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User findById(long id){
        return userRepository.findOne(id);
    }

    public void saveEmployer(User user){

        user.addRole(roleRepository.findRoleByRoleName("EMPLOYER"));

        userRepository.save(user);
    }

    public void saveApplicant(User user){
        user.addRole(roleRepository.findRoleByRoleName("APPLICANT"));
        userRepository.save(user);
    }

    public void saveRecruiter(User user){
        user.addRole((roleRepository.findRoleByRoleName("RECRUITER")));
        userRepository.save(user);
    }

    public Long countByUsername(String username){
        return userRepository.countByUsername(username);
    }

    public void addNewBasic(User user, Basic basic){
        basicRepository.save(basic);
        Set<Basic> basics = user.getBasics();
        basics.add(basic);
        user.setBasics(basics);
        userRepository.save(user);
    }

    public void addNewDegree(User user, Degree degree){
        educationRepository.save(degree);
        Set<Degree> degrees = user.getDegrees();
        degrees.add(degree);
        user.setDegrees(degrees);
        userRepository.save(user);
    }

    public void addNewExperience(User user, Experience experience){
        experiencesRepository.save(experience);
        Set<Experience> experiences = user.getExperiences();
        experiences.add(experience);
        user.setExperiences(experiences);
        userRepository.save(user);
    }

    public void addNewCL(User user, CoverLetter coverLetter){
        clRepository.save(coverLetter);
        Set<CoverLetter> coverLetters = user.getCoverLetters();
        coverLetters.add(coverLetter);
        user.setCoverLetters(coverLetters);
        userRepository.save(user);
    }

    public void addNewReference(User user, Reference reference){
        referenceRepository.save(reference);
        Set<Reference> references = user.getReferences();
        references.add(reference);
        user.setReferences(references);
        userRepository.save(user);
    }

    public void addNewSkill(User user, Skill skill){
        skillsRepository.save(skill);
        Set<Skill> skills = user.getSkills();
        skills.add(skill);
        user.setSkills(skills);
        userRepository.save(user);
    }

    public Iterable<Basic> getAllBasics(User user){
        return user.getBasics();
    }

    public Iterable<Skill> getAllSkills(User user){
        return user.getSkills();
    }

    public Iterable<Degree> getAllDegrees(User user){
        return user.getDegrees();
    }

    public Iterable<Experience> getAllExperiences(User user){
        return user.getExperiences();
    }

    public Iterable<Reference> getAllReferences(User user){
        return user.getReferences();
    }

    public Iterable<CoverLetter> getAllCoverLetters(User user){
        return user.getCoverLetters();
    }

    public Basic getBasic(long id){
        return basicRepository.findOne(id);
    }

    public CoverLetter getCoverLetter(long id){
        return clRepository.findOne(id);
    }

    public Degree getDegree(long id){
        return educationRepository.findOne(id);
    }

    public Experience getExperience(long id){
        return experiencesRepository.findOne(id);
    }

    public Skill getSkill(long id){
        return skillsRepository.findOne(id);
    }

    public Reference getReference(long id){
        return referenceRepository.findOne(id);
    }

    public void deleteReference(long id){
        referenceRepository.delete(id);
    }

    public void deleteSkill(long id){
        skillsRepository.delete(id);
    }

    public void deleteExperience(long id){
        experiencesRepository.delete(id);
    }

    public void deleteDegree(long id){
        educationRepository.delete(id);
    }

    public void deleteBasic(long id){
        basicRepository.delete(id);
    }

    public void deleteCoverLetter(long id){
        clRepository.delete(id);
    }


    public void saveJob(Job job){
        jobRepository.save(job);
    }


//    public void setBasics(User user, Basic basic){
//        basicRepository.save(basic);
//        Collection<Basic> basics = new HashSet<>();
//        basics.add(basic);
//        user.setBasics(basics);
//        userRepository.save(user);
//    }
//
//    public void setBasics(User user, Basic basic){
//        basicRepository.save(basic);
//        Collection<Basic> basics = new HashSet<>();
//        basics.add(basic);
//        user.setBasics(basics);
//        userRepository.save(user);
//    }


}