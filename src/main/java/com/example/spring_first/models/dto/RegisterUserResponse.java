package com.example.spring_first.models.dto;

import javax.persistence.criteria.CriteriaBuilder;

public class RegisterUserResponse extends BaseResponse{

    private Long id;
    private String username;
    private String email;

    public RegisterUserResponse(String status, Integer code) {
        super(status, code);
    }

    public RegisterUserResponse(String status, Integer code, String username, String email){
        super(status, code);
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
