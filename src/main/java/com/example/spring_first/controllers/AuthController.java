package com.example.spring_first.controllers;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.*;
import com.example.spring_first.services.AuthService;
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
    private final AuthService authService;

    @Autowired
    public AuthController(UserService userService, AuthService authService){
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/registration")
    public UserResponse regUser(@RequestBody RegisterUserRequest registerUserRequest){
        try{
           return userService.registerUser(registerUserRequest);
        }catch (Error | NoSuchAlgorithmException error){
            System.out.println(error.getMessage());
        }
        return new UserResponse(ResponseStatus.ERROR_STATUS, ResponseStatusCode.INVALID_DATA);
    }

    @PostMapping("/login")
    public LoginUserResponse loginUser(@RequestBody LoginUserRequest loginUserRequest) throws NoSuchAlgorithmException {
       return authService.loginUser(loginUserRequest);
    }

    @PostMapping("/logout")
    public BaseResponse logoutUser(){
        return new BaseResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
    }
}
