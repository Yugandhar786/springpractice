package com.example.springpractice.service;

import com.example.springpractice.SecurityConfig;
import com.example.springpractice.entity.Users;
import com.example.springpractice.repository.UserRepository;
import com.example.springpractice.requestDto.UserDTO;
import com.example.springpractice.requestDto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;
    private SecurityConfig securityConfig;

    public UserService(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
    }

    public Users registerUser(UserRegisterDTO userRegisterDTO){

        Users users = new Users();

        users.setId(userRegisterDTO.getId());
        users.setEmail(userRegisterDTO.getEmail());
        users.setUserName(userRegisterDTO.getUserName());
        users.setPassWord(securityConfig.passwordEncoder().encode(userRegisterDTO.getPassWord()));
        users.setRole(userRegisterDTO.getRole());
        return userRepository.save(users);
    }

    public List<Users> listAllUsers(){
        return userRepository.findAll();
    }


}
