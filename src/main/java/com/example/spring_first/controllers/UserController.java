package com.example.spring_first.controllers;

import com.example.spring_first.constants.Paths;
import com.example.spring_first.exceptions.BaseException;
import com.example.spring_first.models.dto.UserResponse;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(Paths.userBase)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userservice){
        this.userService = userservice;
    }

    @RequestMapping(value = Paths.userGetAll, method= RequestMethod.GET)
    public  ResponseEntity<UserResponse> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        try {
            UserResponse userResponse = userService.getUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        }catch( BaseException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not found!", ex);
        }
    }
}
