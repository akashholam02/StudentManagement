package com.managmnetSystem.StudentManagment.controller;

import com.managmnetSystem.StudentManagment.entity.Student;
import com.managmnetSystem.StudentManagment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private studentService studentService;

    @GetMapping
    public List<Student>getall(){
       return  studentService.getall();
    }
}
