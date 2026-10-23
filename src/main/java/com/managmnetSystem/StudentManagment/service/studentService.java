package com.managmnetSystem.StudentManagment.service;

import com.managmnetSystem.StudentManagment.entity.Student;
import com.managmnetSystem.StudentManagment.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentService {
    @Autowired
    private  studentRepository studentRepository;

    public List<Student>getall(){
        return studentRepository.findAll();
    }

}
