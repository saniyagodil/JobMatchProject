package com.company.resume;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class basicResume {

    @NotNull
    @Size(min = 10)
    private String email;

    @NotNull
    @Size(min = 3)
    private String name;

    public basicResume(){

    }

    public basicResume(String e, String n){
        this.email = e;
        this.name = n;
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
}
