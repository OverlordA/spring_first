package com.example.spring_first.controllers;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.*;
import com.example.spring_first.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registration")
    public UserResponse regUser(@RequestBody RegisterUserRequest registerUserRequest){
        try{
           User user = userService.registerUser(registerUserRequest);
            return new UserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS,user.getUsername(), user.getEmail());
        }catch (Error | NoSuchAlgorithmException error){
            System.out.println(error.getMessage());
        }
        return new UserResponse(ResponseStatus.ERROR_STATUS, ResponseStatusCode.INVALID_DATA);
    }

    @PostMapping("/login")
    public LoginUserResponse loginUser(@RequestBody LoginUserRequest loginUserRequest){
        return new LoginUserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
    }

    @PostMapping("/logout")
    public BaseResponse logoutUser(){
        return new BaseResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
    }
}
