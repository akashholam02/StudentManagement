package com.managmnetSystem.StudentManagment.service;

import com.managmnetSystem.StudentManagment.entity.Student;
import com.managmnetSystem.StudentManagment.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    private  studentRepository studentRepository;

    public List<Student>getall(){
        return studentRepository.findAll();
    }
    public Student saveStudent(Student newStudent){
        studentRepository.save(newStudent);
        return newStudent;
    }
    public Student getById(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    public void deleteAll(){
        studentRepository.deleteAll();
    }
    public Student update(Long id,Student updated){
        Student old=studentRepository.findById(id).orElse(null);
        if(old !=null){
            old.setName(updated.getName()!=null && updated.getName().equals("")?updated.getName() : old.getName());
            old.setEmail(updated.getEmail()!=null && updated.getEmail().equals("")? updated.getEmail() : old.getEmail());
        }
        studentRepository.save(old);
        return old;
    }

}
