package com.example.springpractice.controllers;


import com.example.springpractice.service.UserService;
import com.example.springpractice.requestDto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    private UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<Set<UserDTO>> getUser() {
        return ResponseEntity.ok(userService.getUsers());
    }


}
