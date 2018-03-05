package com.company.resume.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String positionName;

    @Column
    private String positionDescription;

    @ManyToMany
    private Set<Skill> jobSkills;

    @ManyToOne
    private Organization jobOrg;

    @Column
    private ArrayList<String> applied;

    @Column
    private ArrayList<String> shortlist;

    private String status; //notqualified, qualified, applied, shortlist

    public Job() {
        this.jobSkills = new HashSet<>();
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

    public ArrayList<String> getApplied() {
        return applied;
    }

    public void setApplied(ArrayList<String> applied) {
        this.applied = applied;
    }

    public void addApplicant(String user){
        this.applied.add(user);
    }

    public ArrayList<String> getShortlist() {
        return shortlist;
    }

    public void setShortlist(ArrayList<String> shortlist) {
        this.shortlist = shortlist;
    }

    public void addToShortlist(String user){
        this.shortlist.add(user);
    }
}
