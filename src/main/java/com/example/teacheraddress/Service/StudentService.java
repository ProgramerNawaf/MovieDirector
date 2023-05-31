package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.ApiException;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Student;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.CourseRepo;
import com.example.teacheraddress.Repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void addStudent(Student c){
        studentRepo.save(c);
    }

    public void updateStudent(Student s , Integer id){
        Student s1 =studentRepo.findStudentById(id);
        if(s1 == null)
            throw new ApiException("course with this id dosent exist!");
        s1.setName(s.getName());
        s1.setAge(s.getAge());
        s1.setMajor(s.getMajor());
        studentRepo.save(s1);
    }

    public void deleteStudent(Integer id){
        Student s = studentRepo.findStudentById(id);
        if(s==null)
            throw new ApiException("course with this id dosent exist!");
        List<Course> courses =courseRepo.findCoursesByStudentsContains(s);

        for(int i=0 ; i<courses.size() ; i++)
                courses.get(i).getStudents().remove(s);


        studentRepo.delete(studentRepo.findStudentById(id));
    }

    public void changeMajor(Integer id, String major){
        Student s = studentRepo.findStudentById(id);
        if(s==null)
            throw new ApiException("course with this id dosent exist!");
        List<Course> courses =courseRepo.findCoursesByStudentsContains(s);

        for(int i=0 ; i<courses.size() ; i++)
            courses.get(i).getStudents().remove(s);

        s.setMajor(major);
        studentRepo.save(s);
    }



    public void assignStudents(Integer studentId,Integer courseId){
        Course c =courseRepo.findCourseById(courseId);
        Student s =studentRepo.findStudentById(studentId);
        if(c==null || s==null ){
            throw new ApiException("course or teacher not found");
        }
        c.getStudents().add(s);
        s.getCourses().add(c);
        courseRepo.save(c);
        studentRepo.save(s);
    }
}
