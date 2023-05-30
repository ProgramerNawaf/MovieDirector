package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Student;
import com.example.teacheraddress.Model.Student;

import com.example.teacheraddress.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student c){
        studentService.addStudent(c);
        return ResponseEntity.status(200).body("Student added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student c , @PathVariable Integer id){
        studentService.updateStudent(c,id);
        return ResponseEntity.status(200).body("Student updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted!");
    }
    @PutMapping("/assign/{courseId}/{studentId}")
    public ResponseEntity assignStudents(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.assignStudents(studentId,courseId);
        return ResponseEntity.status(200).body("Student assigned!");
    }
}
