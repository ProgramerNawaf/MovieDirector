package com.example.teacheraddress.Repo;

import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
    @Query("select s from Course s where s.teacherCourses.id = ?1")
    List<Course> getTeacherCourses(Integer teacherId);

    List<Course> findCoursesByStudentsContains(Student s);

}
