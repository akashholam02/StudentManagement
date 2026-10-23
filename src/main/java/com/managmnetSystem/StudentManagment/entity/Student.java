package com.managmnetSystem.StudentManagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private String email;
    private String CourseName;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setCourseName(String CourseName){
        this.CourseName=CourseName;
    }
    public String getCourseName(){
        return CourseName;
    }

}
