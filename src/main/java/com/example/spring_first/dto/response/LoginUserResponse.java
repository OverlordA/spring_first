package com.example.spring_first.dto.response;

public class LoginUserResponse extends BaseResponse{

    private String token;

    public LoginUserResponse(String status, Integer code) {
        super(status, code);
    }

    public LoginUserResponse(String status, Integer code, String token){
        super(status, code);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
