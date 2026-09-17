package com.example.springpractice.repository;


import com.example.springpractice.entity.Student;
import com.example.springpractice.requestDto.StudentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByName(String Name);

    List<Student> findByEmail(String Email);


    @Query("SELECT COUNT(s.email) FROM Student s")
    long findCountOfEmail();

    @Query("SELECT COUNT(s) FROM Student s WHERE s.email = :email")
    long findCountOfEmail(@Param("email") String email);

    @Query("SELECT s FROM Student s WHERE s.name LIKE :name")
    List<Student> findTheCountOfIdenticalNames(@Param("name") String name);

}
