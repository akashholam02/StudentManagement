package com.managmnetSystem.StudentManagment.repository;

import com.managmnetSystem.StudentManagment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student,Long> {

}
