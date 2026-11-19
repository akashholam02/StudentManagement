package com.managmnetSystem.StudentManagment.controller;

import com.managmnetSystem.StudentManagment.entity.Course;
import com.managmnetSystem.StudentManagment.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class courseController {
    @Autowired
    private courseService courseService;

    @GetMapping
    public ResponseEntity<?>getall(){
        List<Course>courses=courseService.getall();
        return ResponseEntity.ok(courses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        Course getById=courseService.getbyid(id);
        if(getById !=null){
            return new ResponseEntity<>(getById,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?>saveCourse(@RequestBody Course myCourse){
        Course mycourse=courseService.saveCourse(myCourse);
        return new ResponseEntity<>(mycourse,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        courseService.deletecourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/all")
    public ResponseEntity<?>deleteAll(){
        courseService.deleteall();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updated(@PathVariable Long id, @RequestBody Course newEntry) {

        Course result = courseService.getbyid(id);
        if (result!=null) {
            Course old = result;
            old.setCourseName(
                    newEntry.getCourseName() != null && !newEntry.getCourseName().isEmpty()
                            ? newEntry.getCourseName() : old.getCourseName()
            );
            old.setDuration(
                    newEntry.getDuration() != null && !newEntry.getDuration().isEmpty()
                            ? newEntry.getDuration() : old.getDuration()
            );
            old.setFees(
                    newEntry.getFees() != null
                            ? newEntry.getFees() : old.getFees()
            );
            courseService.saveCourse(old);

            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }

}
