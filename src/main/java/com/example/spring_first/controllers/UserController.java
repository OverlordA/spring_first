package com.example.spring_first.controllers;

import com.example.spring_first.models.dto.UserResponse;
import com.example.spring_first.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userservice){
        this.userService = userservice;
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public  ResponseEntity<UserResponse> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
}
