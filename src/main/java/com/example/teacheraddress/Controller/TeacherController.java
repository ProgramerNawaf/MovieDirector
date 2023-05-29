package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.TeacherRepo;
import com.example.teacheraddress.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeachers(@Valid @RequestBody Teacher t){
        teacherService.addTeacher(t);
        return ResponseEntity.status(200).body("Teacher added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher t , @PathVariable Integer id){
        teacherService.updateTeacher(t,id);
        return ResponseEntity.status(200).body("Teacher updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted!");
    }

}
