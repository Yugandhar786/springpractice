package com.example.springpractice.requestDto;

import com.example.springpractice.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequest {

    @NotBlank
    private String name;
    @Email
    private String email;
//    @Min(18)
//    private Integer age;


    public StudentRequest(){}

    public StudentRequest(String name, String email) {
        this.name = name;
        this.email = email;
//        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

}
