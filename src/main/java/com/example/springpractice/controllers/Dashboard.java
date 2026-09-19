package com.example.springpractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dashboard {

    @GetMapping("/dashboard")
    public String dashboardPage(){
        return "Welcome To the Dashboard";
    }

}
