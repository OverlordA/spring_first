package com.example.spring_first.services;

import com.example.spring_first.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    public String calculateJWT(User user){
        Date nowDate = new Date();

        String jwtStr = Jwts.builder()
                .setSubject("ME")
                .claim("id", user.getId())
                .claim("name",user.getUsername())
                .claim("email",user.getEmail())
                .claim("date", nowDate.toString())
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode("testSecret"))
                .compact();
        return jwtStr;
    }
}
