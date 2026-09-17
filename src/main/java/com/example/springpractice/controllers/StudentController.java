package com.example.springpractice.controllers;


import com.example.springpractice.entity.Student;
import com.example.springpractice.requestDto.StudentRequest;
import com.example.springpractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudents(){
//        return studentService.getAllStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent( @Valid @RequestBody Student student){
//        return studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteStudent(@PathVariable Long id){
//        return studentService.deleteStudent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.deleteStudent(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findAStudent(@PathVariable Long id ){
//        return studentService.getStudentById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.getStudentById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> findAStudentByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findByName(name));
    }

    @GetMapping("/search/email")
    public ResponseEntity<List<Student>> findAStudentByEmail(@RequestParam String email){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findByEmail(email));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> findTheListOfEmails(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findTheCountOfEmails());
    }

    @GetMapping("/get_students_with/identical_Name")
    public ResponseEntity<List<StudentRequest>> findIdenticalName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findTheCountOfIdenticalNamesOnDB(name));
    }


}
