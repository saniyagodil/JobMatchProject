package com.company.resume.Models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    @Size(min = 3)
    private String name;

    @Column
    private String level;

    @ManyToMany(mappedBy = "skills")
    private List<User> users;

    @ManyToMany(mappedBy = "jobSkills")
    private List<Job> jobs;

    public Skill(){
    }

    public Skill(String name, String level){
        this.name = name;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + name + '\'' +
                ", proficiency='" + level + '\'' +
                '}';
    }

}



