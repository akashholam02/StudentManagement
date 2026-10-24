package com.managmnetSystem.StudentManagment.controller;

import com.managmnetSystem.StudentManagment.entity.Student;
import com.managmnetSystem.StudentManagment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/id/{id}")
    public Student findByid(@PathVariable Long id){
        return studentService.getById(id);
    }
    @PostMapping
    public Student saveStudent(@RequestBody Student newStudent){
        return studentService.saveStudent(newStudent);
    }
    @DeleteMapping("/id/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student Deleted Successfully";
    }
    @DeleteMapping("delete-all")
    public String deleteAll(){
        studentService.deleteAll();
        return "All Record deleted";
    }
    @PutMapping("id/{id}")
    public Student updated(@PathVariable Long id,@RequestBody Student updated){
        studentService.update(id,updated);
        return updated;
    }
}
