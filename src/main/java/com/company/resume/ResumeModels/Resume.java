package com.company.resume.ResumeModels;


import com.company.resume.ResumeRepositories.*;
import com.company.resume.UserSetup.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @OneToMany
    private Set<Basic> basics;

    @Column
    @OneToMany
    private Set<Degree> educations;

    @Column
    @OneToMany
    private Set<Experience> experiences;

    @Column
    @OneToMany
    private Set<Skill> skills;

    @Column
    @OneToMany
    private Set<Reference> references;


    @Column
    @OneToMany
    private Set<CoverLetter> coverLetters;


    @OneToOne
    private User user;

    public Resume() {
    }

    public Resume(Set<Basic> basics, Set<CoverLetter> coverLetters, Set<Reference> references, Set<Degree> educations, Set<Experience> experiences, Set<Skill> skills, User user) {
        this.basics = basics;
        this.references = references;
        this.coverLetters = coverLetters;
        this.educations = educations;
        this.experiences = experiences;
        this.skills = skills;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Degree> getEducations() {
        return educations;
    }

    public void setEducations(Set<Degree> educations) {
        this.educations = educations;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    public Set<CoverLetter> getCoverLetters() {
        return coverLetters;
    }

    public void setCoverLetters(Set<CoverLetter> coverLetters) {
        this.coverLetters = coverLetters;
    }

    public Set<Basic> getBasics() {
        return basics;
    }

    public void setBasics(Set<Basic> basics) {
        this.basics = basics;
    }
}

