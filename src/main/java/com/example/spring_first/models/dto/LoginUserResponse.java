package com.example.spring_first.models.dto;

public class LoginUserResponse extends BaseResponse{

    private String token;

    public LoginUserResponse(String status, Integer code) {
        super(status, code);
    }
}
