package com.managmnetSystem.StudentManagment.repository;

import com.managmnetSystem.StudentManagment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Course,Long> {
}
