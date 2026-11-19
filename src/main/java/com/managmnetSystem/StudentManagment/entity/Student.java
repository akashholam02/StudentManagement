package com.managmnetSystem.StudentManagment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name=name;
//    }
//    public void setId(Long id){
//        this.id=id;
//    }
//    public Long getId(){
//        return id;
//    }
//    public void setEmail(String email){
//        this.email=email;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public void setCourseName(String CourseName){
//        this.CourseName=CourseName;
//    }
//    public String getCourseName(){
//        return CourseName;
//    }

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

}
