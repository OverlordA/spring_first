package com.example.spring_first.exception;

public class BaseException extends RuntimeException {
    public BaseException(){
        super();
    }
    public BaseException(String message){
        super(message);
    }
}