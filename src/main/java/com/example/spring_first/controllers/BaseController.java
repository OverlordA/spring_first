package com.example.spring_first.controllers;

import com.example.spring_first.constants.Paths;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.base)
public class BaseController {

    @GetMapping
    public ResponseEntity<String> home(){
        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>("Base url: '/', server is worked",  httpHeaders, HttpStatus.OK);
    }
}
