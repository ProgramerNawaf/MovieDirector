package com.example.teacheraddress.Repo;

import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);

}
