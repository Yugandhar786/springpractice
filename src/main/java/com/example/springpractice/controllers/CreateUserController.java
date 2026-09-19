package com.example.springpractice.controllers;


import com.example.springpractice.entity.Users;
import com.example.springpractice.requestDto.UserRegisterDTO;
import com.example.springpractice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    private final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(userRegisterDTO));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAllUsers());
    }


}
