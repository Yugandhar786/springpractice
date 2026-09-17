package com.example.springpractice.service;

import com.example.springpractice.entity.Student;
import com.example.springpractice.exception.StudentNotFoundException;
import com.example.springpractice.repository.StudentRepository;
import com.example.springpractice.requestDto.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String deleteStudent(Long id ){

        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }

        studentRepository.deleteById(id);
        return "Student "+id+" deleted Successfully";
    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(id));
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> findByEmail(String name) {
        return studentRepository.findByEmail(name);
    }

    public long findTheCountOfEmails(){
        return studentRepository.findCountOfEmail();
    }
    public List<StudentRequest> findTheCountOfIdenticalNamesOnDB(String name){
        List<Student> students = studentRepository.findTheCountOfIdenticalNames(name+"_%");

        return students.stream().map(student -> new StudentRequest(student.getEmail(),student.getName()))
                .collect(Collectors.toList()) ;
    }






}
