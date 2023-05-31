package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.ApiException;
import com.example.teacheraddress.Model.Address;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.CourseRepo;
import com.example.teacheraddress.Repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;
    private final CourseRepo courseRepo;

    public List<Teacher> getTeachers(){
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher t){
        teacherRepo.save(t);
    }

    public void updateTeacher(Teacher t,Integer id){
        Teacher tOld =teacherRepo.findTeacherById(id);
        if(tOld == null)
            throw new ApiException("no teacher with this id!");
        tOld.setAddress(t.getAddress());
        tOld.setAge(t.getAge());
        tOld.setName(t.getName());
        tOld.setSalary(t.getSalary());
        tOld.setEmail(t.getEmail());
        teacherRepo.save(tOld);
    }
    //only deletes when teacher has no courses
    public void deleteTeacher(Integer teacherid){
        Teacher t =teacherRepo.findTeacherById(teacherid);
        List<Course> c = courseRepo.getTeacherCourses(teacherid);
        if(t == null)
            throw new ApiException("no teacher with this id!");

        for(int i = 0 ; i<t.getCourses().size();i++) {
             c.get(i).setTeacherCourses(null);
             courseRepo.save(c.get(i));
        }
        teacherRepo.delete(t);
    }

    public Teacher getTeacher(Integer id){
        if(teacherRepo.findTeacherById(id) == null)
            throw new ApiException("No teacher with this id!");
        return teacherRepo.findTeacherById(id);
    }
}
