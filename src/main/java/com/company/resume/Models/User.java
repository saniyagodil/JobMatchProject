package com.company.resume.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column @Size(min = 3)
    private String name;

    @Column @Size(min = 3)
    private String email;

    @Column
    private String linkedIn;

    @Column
    private String gitHub;

    @Column
    private String img;
    @Column
    private String summary;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


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


    private String organization;


    public User() {
        this.roles = new HashSet<>();
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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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


    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
