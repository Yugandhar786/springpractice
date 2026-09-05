package com.example.springpractice.controllers;


import com.example.springpractice.entity.Student;
import com.example.springpractice.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public String DeleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
