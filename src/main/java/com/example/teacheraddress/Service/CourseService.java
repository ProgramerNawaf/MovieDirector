package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.ApiException;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.CourseRepo;
import com.example.teacheraddress.Repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;
    private final TeacherRepo teacherRepo;

    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    public void addCourse(Course c){
        courseRepo.save(c);
    }

    public void updateCourse(Course c , Integer id){
        Course course =courseRepo.findCourseById(id);
        if(course == null)
            throw new ApiException("course with this id dosent exist!");
        course.setName(c.getName());
        courseRepo.save(course);
    }

    public void deleteCourse(Integer id){
        if(courseRepo.findCourseById(id)==null)
            throw new ApiException("course with this id dosent exist!");
        courseRepo.delete(courseRepo.findCourseById(id));
    }

    public void assignCourses(Integer teacherId,Integer courseId){
        Course c =courseRepo.findCourseById(courseId);
        Teacher t =teacherRepo.findTeacherById(teacherId);
        if(c==null || t==null ){
            throw new ApiException("course or teacher not found");
        }
        c.setTeacherCourses(t);
        courseRepo.save(c);
    }

    public String teacherName(Integer courseId){
        if(courseRepo.findCourseById(courseId) == null)
            throw new ApiException("course ID dosent exist");
        return courseRepo.findCourseById(courseId).getTeacherCourses().getName();
    }
}
