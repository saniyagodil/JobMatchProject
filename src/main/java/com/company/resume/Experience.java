package com.company.resume;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 5)
    private String positionTitle;

    @NotNull
    @Size(min = 2)
    private String organization;

    @NotNull
    @Size(min = 10)
    private String duties;

    @NotNull
    @Size(min = 9)
    private String startDate; //use bootstrap to make it default month yyyy

    @NotNull
    @Size(min = 9)
    private String endDate;

    public Experience(){

    }
    public Experience(String t, String o, String d, String s, String e){
        this.positionTitle = t;
        this.organization = o;
        this.duties = d;
        this.startDate = s;
        this.endDate = e;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
