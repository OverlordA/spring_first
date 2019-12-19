package com.example.spring_first.models.dto;

public class RegisterUserResponse extends BaseResponse{

    private Long id;
    private String username;
    private String email;

    public RegisterUserResponse(String status, Integer code) {
        super(status, code);
    }

}
