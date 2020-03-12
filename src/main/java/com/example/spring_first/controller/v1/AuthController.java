package com.example.spring_first.controller.v1;

import com.example.spring_first.constants.Paths;
import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.dto.response.*;
import com.example.spring_first.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(Paths.authBase)
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping(Paths.registration)
    public UserResponse regUser(@RequestBody RegisterUserRequest registerUserRequest){
        try{
           return authService.registerUser(registerUserRequest);
        }catch (Error | NoSuchAlgorithmException error){
            System.out.println(error.getMessage());
        }
        return new UserResponse(ResponseStatus.ERROR_STATUS, ResponseStatusCode.INVALID_DATA);
    }

    @PostMapping(Paths.login)
    public LoginUserResponse loginUser(@RequestBody LoginUserRequest loginUserRequest) throws NoSuchAlgorithmException {
       return authService.loginUser(loginUserRequest);
    }

    @PostMapping(Paths.logout)
    public BaseResponse logoutUser(){
        return new BaseResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
    }
}
