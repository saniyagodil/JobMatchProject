package com.company.resume.ResumeModels;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2)
    private String degreeType;

    @NotNull
    @Size(min = 5)
    private String major;

    @NotNull
    @Size(min = 2)
    private String school;

    @NotNull
    @Size(min = 4)
    private String gradYear;

    @ManyToOne
    private Resume resume;

    public Degree(){

    }
    public Degree(String d, String m, String s, String y){
        this.degreeType = d;
        this.major = m;
        this.school = s;
        this.gradYear = y;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
