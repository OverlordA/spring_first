package com.example.spring_first.dto.response;

import com.example.spring_first.dto.model.User;

import java.util.List;

public class Response extends BaseResponse {

    private List<User> data;

    public Response(String status, Integer code) {
        super(status, code);
    }

    public Response(String status, Integer code, List<User> users ){
        super(status, code);
        this.data = users;
    }
}
