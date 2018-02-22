package com.company.resume.ResumeModels;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private String positionName;

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Skill> skills;

    @Column
    @NotNull
    private String company;

    public Job() {
    }

    public Job(String positionName, Collection<Skill> skills, String company) {
        this.positionName = positionName;
        this.skills = skills;
        this.company = company;
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

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
