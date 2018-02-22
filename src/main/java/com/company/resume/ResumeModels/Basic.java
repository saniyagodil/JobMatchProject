package com.company.resume.ResumeModels;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Basic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @ManyToOne
    private Resume resume;

    @NotNull
    @Size(min = 10)
    private String email;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 3)
    private String linkedIn;

    @NotNull
    @Size(min = 3)
    private String gitHub;

    @NotNull
    @Size(min = 5)
    private String img;

    @NotNull
    private String summary;




    public Basic(){

    }

    public Basic(String e, String n, String l, String g){
        this.email = e;
        this.name = n;
        this.linkedIn = l;
        this.gitHub = g;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
