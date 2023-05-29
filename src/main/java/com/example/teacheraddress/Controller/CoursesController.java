package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CoursesController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(courseService.getCourses());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course c){
        courseService.addCourse(c);
        return ResponseEntity.status(200).body("Course added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course c , @PathVariable Integer id){
        courseService.updateCourse(c,id);
        return ResponseEntity.status(200).body("Course updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted!");
    }
    @PutMapping("/assign/{teacherId}/{courseId}")
    public ResponseEntity assignCourses(@PathVariable Integer teacherId,@PathVariable Integer courseId){
        courseService.assignCourses(teacherId,courseId);
        return ResponseEntity.status(200).body("Course assigned!");
    }
    @GetMapping("/teacher-name/{courseId}")
    public ResponseEntity teacherName(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body("Teacher name is: "+courseService.teacherName(courseId));
    }
}
