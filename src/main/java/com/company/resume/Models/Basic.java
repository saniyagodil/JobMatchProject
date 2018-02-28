package com.company.resume.Models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Basic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    @Size(min = 3)
    private String email;

    @Column
    @NotNull
    @Size(min = 3)
    private String name;

    @Column
    @NotNull
    @Size(min = 3)
    private String linkedIn;

    @Column
    @NotNull
    @Size(min = 3)
    private String gitHub;

    @Column
    @NotNull
    @Size(min = 3)
    private String img;

    @Column
    @NotNull
    @Size(min = 3)
    private String summary;

    @ManyToMany(mappedBy = "basics")
    private Collection<User> users;

    public Basic(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Basic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}


