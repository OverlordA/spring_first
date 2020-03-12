package com.example.spring_first.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserRequest {
    private String username;
    private String password;
}
