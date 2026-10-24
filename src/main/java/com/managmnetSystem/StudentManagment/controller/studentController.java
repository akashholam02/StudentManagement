package com.managmnetSystem.StudentManagment.controller;

import com.managmnetSystem.StudentManagment.entity.Student;
import com.managmnetSystem.StudentManagment.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private studentService studentService;

    @GetMapping
    public ResponseEntity<?>getall(){
        List<Student>allstudents=studentService.getall();
        return new ResponseEntity<>(allstudents,HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id){
        Student getById=studentService.getById(id);
        if(getById!=null){
            return new ResponseEntity<>(getById,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student newStudent){
         studentService.saveStudent(newStudent);
         return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete-all")
    public ResponseEntity<?> deleteAll(){
        studentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("id/{id}")
    public ResponseEntity<?> updated(@PathVariable Long id,@RequestBody Student updated){
        studentService.update(id,updated);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
