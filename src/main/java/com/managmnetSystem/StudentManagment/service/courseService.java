package com.managmnetSystem.StudentManagment.service;

import com.managmnetSystem.StudentManagment.entity.Course;
import com.managmnetSystem.StudentManagment.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class courseService {
    @Autowired
    private courseRepository courseRepository;

    public List<Course>getall(){
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    public Course getbyid(Long id){
        return courseRepository.findById(id).orElse(null);
    }
    public void deletecourse(Long id){
        courseRepository.deleteById(id);
    }
    public void deleteall(){
        courseRepository.deleteAll();
    }

}
