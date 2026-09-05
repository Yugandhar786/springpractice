package com.example.springpractice.service;

import com.example.springpractice.requestDto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UserService {

    Set<UserDTO> userList = new LinkedHashSet<>();

    public String createUser(UserDTO userDTO){
        userList.add(userDTO);
        return "User Created";
    }

    public Set<UserDTO> getUsers(){
        return userList;
    }

}
