package com.example.springpractice.practiceController;

import com.example.springpractice.practiceService.UserService1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private UserService1 userService;

    UserController(UserService1 userService){
        this.userService = userService;
    }


//    @GetMapping("/{id}")
//    public String getUserid(
//            @PathVariable Integer id){
//        return userService.getUserId(id);
//    }

}

