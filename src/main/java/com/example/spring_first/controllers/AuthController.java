package com.example.spring_first.controllers;

import com.example.spring_first.constants.Status;
import com.example.spring_first.models.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/registration")
    public RegisterUserResponse regUser(@RequestBody RegisterUserRequest registerUserRequest){
            return new RegisterUserResponse(Status.SUCCESS_STATUS, Status.CODE_SUCCESS);
    }

    @PostMapping("/login")
    public LoginUserResponse loginUser(@RequestBody LoginUserRequest loginUserRequest){
        return new LoginUserResponse(Status.SUCCESS_STATUS, Status.CODE_SUCCESS);
    }

    @PostMapping("/logout")
    public BaseResponse logoutUser(){
        return new BaseResponse(Status.SUCCESS_STATUS, Status.CODE_SUCCESS);
    }
}
