package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.ApiException;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;

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

    public void deleteTeacher(Integer id){
        Teacher tOld =teacherRepo.findTeacherById(id);
        if(tOld == null)
            throw new ApiException("no teacher with this id!");
        teacherRepo.delete(tOld);
    }
}
