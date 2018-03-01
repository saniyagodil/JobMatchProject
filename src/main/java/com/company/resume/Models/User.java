package com.company.resume.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany
    private Set<Basic> basics;

    @ManyToMany
    private Set<Degree> degrees;

    @ManyToMany
    private Set<Experience> experiences;

    @ManyToMany
    private Set<Skill> skills;

    @ManyToMany
    private Set<CoverLetter> coverLetters;

    @ManyToMany
    private Set<Reference> references;

    @ManyToMany
    private Set<Job> jobs;



    public User() {
        this.basics = new HashSet<>();
        this.degrees = new HashSet<>();
        this.experiences = new HashSet<>();
        this.skills = new HashSet<>();
        this.coverLetters = new HashSet<>();
        this.references = new HashSet<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void addBasic(Basic basic) {
        this.basics.add(basic);
    }

    public void addEducation(Degree degree) {
        this.degrees.add(degree);
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void addExperience(Experience experience){
        this.experiences.add(experience);
    }

    public void addCoverLetter(CoverLetter coverLetter){
        this.coverLetters.add(coverLetter);
    }

    public void addReference(Reference reference){
        this.references.add(reference);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Set<Basic> getBasics() {
        return basics;
    }

    public void setBasics(Set<Basic> basics) {
        this.basics = basics;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
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

    public Set<CoverLetter> getCoverLetters() {
        return coverLetters;
    }

    public void setCoverLetters(Set<CoverLetter> coverLetters) {
        this.coverLetters = coverLetters;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public void addRole(Role role)
    {
        this.roles.add(role);
    }


}
