package com.example.spring_first.dto.model;

import com.example.spring_first.model.dao.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String email;

    public User(Long id, String username, String email){
        this.username = username;
        this.email = email;
        this.id = id;
    }
    public User(UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
