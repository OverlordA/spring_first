package com.example.spring_first.dto.response;

import lombok.Getter;

@Getter
public class BaseResponse {

    private final String status;
    private final Integer code;

    public BaseResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }
}