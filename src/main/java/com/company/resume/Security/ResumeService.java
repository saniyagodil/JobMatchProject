package com.company.resume.Security;

import com.company.resume.Models.*;
import com.company.resume.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ResumeService {
    @Autowired
    BasicRepository basicRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperiencesRepository experiencesRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private ReferenceRepository referenceRepository;
    @Autowired
    private CLRepository clRepository;

    @Autowired
    public ResumeService(BasicRepository basicRepository, CLRepository clRepository, EducationRepository educationRepository, ExperiencesRepository experiencesRepository, SkillsRepository skillsRepository, ReferenceRepository referenceRepository){
        this.basicRepository = basicRepository;
        this.clRepository = clRepository;
        this.experiencesRepository = experiencesRepository;
        this.educationRepository = educationRepository;
        this.skillsRepository = skillsRepository;
        this.referenceRepository = referenceRepository;
    }

    ///////////////////////////////////////////////////////NEW Skill/Experience/Degree/CoverLetter/Reference/Basic

    public void saveSkill(Skill skill){
        skillsRepository.save(skill);
    }
    public void saveDegree(Degree degree){
        educationRepository.save(degree);
    }
    public void saveExperience(Experience experience){
        experiencesRepository.save(experience);
    }
    public void saveBasic(Basic basic){
        basicRepository.save(basic);
    }
    public void saveReference(Reference reference){
        referenceRepository.save(reference);
    }
    public void saveCoverLetter(CoverLetter coverLetter){
        clRepository.save(coverLetter);
    }

    //////////////////////////////////////////////////////MODIFY RESUME

    ////MODIFY BASIC
    public void editBasicEmail(long id, String email){
        basicRepository.findOne(id).setEmail(email);
    }
    public void editBasicGithub(long id, String github){
        basicRepository.findOne(id).setGitHub(github);
    }
    public void editBasicLinkedIn(long id, String linkedIn){
        basicRepository.findOne(id).setLinkedIn(linkedIn);
    }
    public void editBasicName(long id, String name){
        basicRepository.findOne(id).setName(name);
    }
    public void editBasicImage(long id, String img){
        basicRepository.findOne(id).setImg(img);
    }
    public void editBasicSummary(long id, String summary){
        basicRepository.findOne(id).setSummary(summary);
    }

    ////MODIFY COVERLETTER
    public void editCoverLetter(long id, String letter){
        findCoverLetter(id).setLetter(letter);
    }

    ////MODIFY DEGREE
    public void editDegreeType(long id, String degreeType){
        findDegree(id).setDegreeType(degreeType);
    }
    public void editDegreeYear (long id, String gradYear){
        findDegree(id).setGradYear(gradYear);
    }
    public void editDegreeMajor (long id, String major ){
        findDegree(id).setMajor(major);
    }
    public void editDegreeSchool(long id, String school){
        findDegree(id).setSchool(school);
    }

    ////MODIFY SKILL
    public void editSkillName(long id, String name){
        findSkill(id).setName(name);
    }
    public void editSkillLevel(long id, String level){
        findSkill(id).setLevel(level);
    }

    ////MODIFY EXPERIENCE
    public void editExperienceStartDate(long id, String startDate){
        experiencesRepository.findOne(id).setStartDate(startDate);
    }
    public void editExperiencePositionTitle(long id, String positionTitle){
        experiencesRepository.findOne(id).setPositionTitle(positionTitle);
    }
    public void editExperienceEndDate(long id, String endDate){
        experiencesRepository.findOne(id).setEndDate(endDate);
    }
    public void editExperienceDuties(long id, String duties){
        experiencesRepository.findOne(id).setDuties(duties);
    }
    public void editExperienceOrganization(long id, String organization){
        experiencesRepository.findOne(id).setOrganization(organization);
    }

    ////MODIFY REFERENCE
    public void editReference(long id, String ref){
        findReference(id).setRef(ref);
    }


    //////////////////////////////NEW SKILL/DEGREE/EXPERIENCE/REFERENCE/COVERLETTER
    public void newDegree(Degree degree){
        educationRepository.save(degree);
        ///addd to resume using resume id
    }
    public void newSkill(Skill skill){
        skillsRepository.save(skill);
    }
    public void newExperience(Experience experience){
        experiencesRepository.save(experience);
    }
    public void newReference(Reference reference){
        referenceRepository.save(reference);
    }
    public void newCoverLetter(CoverLetter coverLetter){
        clRepository.save(coverLetter);
    }
    public void newBasic(Basic basic){
        basicRepository.save(basic);
    }

    //////////////////
    public Degree findDegree(long id){
        Degree degree = educationRepository.findOne(id);
        return degree;
    }
    public Skill findSkill(long id){
        Skill skill = skillsRepository.findOne(id);
        return skill;
    }
    public Experience findExperience(long id){
        Experience experience = experiencesRepository.findOne(id);
        return experience;
    }
    public CoverLetter findCoverLetter(long id){
        CoverLetter coverLetter = clRepository.findOne(id);
        return coverLetter;
    }
    public Reference findReference(long id){
        Reference reference = referenceRepository.findOne(id);
        return reference;
    }
    public Basic findBasic(long id){
        Basic basic = basicRepository.findOne(id);
        return basic;
    }


    public Collection<Basic>  getBasic(){
        Collection<Basic> basics = new HashSet<>();
        for (Basic basic : basicRepository.findAll()){
            basics.add(basic);
        }
        return basics;
    }

    public Collection<Skill> getSkills(){
        Collection<Skill> skills = new HashSet<>();
        for (Skill skill : skillsRepository.findAll()){
            skills.add(skill);
        }
        return skills;
    }

    public Collection<Degree> getEducations(){
        Collection<Degree> degrees = new HashSet<>();
        for (Degree degree : educationRepository.findAll()){
            degrees.add(degree);
        }
        return degrees;
    }

    public Collection<Experience> getExperiences(){
        Collection<Experience> experiences = new HashSet<>();
        for (Experience experience : experiencesRepository.findAll()){
            experiences.add(experience);
        }
        return experiences;
    }

    public Collection<Reference> getReferences(){
        Collection<Reference> references = new HashSet<>();
        for (Reference reference : referenceRepository.findAll()){
            references.add(reference);
        }
        return references;
    }

    public Collection<CoverLetter> getCoverLetter(){
        Collection<CoverLetter> coverLetters = new HashSet<>();
        for (CoverLetter coverLetter : clRepository.findAll()){
            coverLetters.add(coverLetter);
        }
        return coverLetters;
    }






}
