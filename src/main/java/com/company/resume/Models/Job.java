package com.company.resume.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String positionName;

    private String positionDescription;

    @ManyToMany
    private Set<Skill> jobSkills;

    @ManyToOne
    private Organization jobOrg;

    @ManyToMany
    private Set<User> applied;

    @ManyToMany
    private Set<User> shortlist;

    private String status; //notqualified, qualified, applied, shortlist

    public Job() {
        this.jobSkills = new HashSet<>();
        this.applied = new HashSet<>();
        this.shortlist = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Set<Skill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(Set<Skill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public void addSkilltoJob(Skill thisSkill){
        this.jobSkills.add(thisSkill);
    }


    public Organization getJobOrg() {
        return jobOrg;
    }

    public void setJobOrg(Organization jobOrg) {
        this.jobOrg = jobOrg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<User> getApplied() {
        return applied;
    }

    public void setApplied(Set<User> applied) {
        this.applied = applied;
    }

    public void addApplicant(User user){
        this.applied.add(user);
    }

    public Set<User> getShortlist() {
        return shortlist;
    }

    public void setShortlist(Set<User> shortlist) {
        this.shortlist = shortlist;
    }

    public void addToShortlist(User user){
        this.shortlist.add(user);
    }
}
