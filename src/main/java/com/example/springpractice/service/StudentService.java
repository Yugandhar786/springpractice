package com.example.springpractice.service;

import com.example.springpractice.entity.Student;
import com.example.springpractice.exception.StudentNotFoundException;
import com.example.springpractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
