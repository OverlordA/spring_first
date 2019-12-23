package com.example.spring_first.controllers;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.dto.UserResponse;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userservice){
        this.userService = userservice;
    }

    @GetMapping("/all")
    public ResponseEntity<UserResponse> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
