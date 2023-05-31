package com.example.teacheraddress.Repo;

import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
    List<Student> findStudentsByCoursesContains(Course c);
}
