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
        if (old != null) {
            if (updated.getName() != null && !updated.getName().isEmpty()) {
                old.setName(updated.getName());
            }

            if (updated.getEmail() != null && !updated.getEmail().isEmpty()) {
                old.setEmail(updated.getEmail());
            }

            if (updated.getCourseName() != null && !updated.getCourseName().isEmpty()) {
                old.setCourseName(updated.getCourseName());
            }

            return studentRepository.save(old);
        }

        return null;
    }

}
