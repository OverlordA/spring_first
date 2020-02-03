package com.example.spring_first.services;

import com.example.spring_first.models.User;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {

    private final UsersRepo usersRepo;

    @Autowired
    public JwtService(UsersRepo usersRepo ){
        this.usersRepo = usersRepo;
    }


    public String calculateJWT(User user, String requestHas){

        // todo save jwt token to Redis or Db
        Date nowDate = new Date();

        String jwtStr = Jwts.builder()
                .setSubject("ME")
                .claim("id", user.getId())
                .claim("name",user.getUsername())
                .claim("passwordHash", requestHas)
                .claim("email",user.getEmail())
                .claim("date", nowDate.toString())
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode("testSecret"))
                .compact();
        return jwtStr;
    }

    public Boolean validateJWT(String token ){
        // todo get token with db or Redis and compare
        String id =  Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode("testSecret"))
                .parseClaimsJws(token).getBody().get("id").toString();
        Long userId = Long.parseLong(id);

        Optional<UserEntity> userOptional = usersRepo.findById(userId);
        UserEntity user = Optional.ofNullable(userOptional).map(value -> value.get()).orElse( new UserEntity());

        String tokenHash = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode("testSecret"))
                .parseClaimsJws(token)
                .getBody().get("passwordHash").toString();

        if(tokenHash.equals(user.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
