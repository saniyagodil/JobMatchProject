package com.company.resume.ResumeRepositories;


import com.company.resume.ResumeModels.Resume;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String letter;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public CoverLetter() {
    }

    public CoverLetter(String letter) {
        this.letter = letter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
