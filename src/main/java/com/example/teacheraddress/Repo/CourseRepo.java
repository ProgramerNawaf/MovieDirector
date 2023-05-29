package com.example.teacheraddress.Repo;

import com.example.teacheraddress.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
}
