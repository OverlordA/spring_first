package com.example.spring_first.models;

import com.example.spring_first.models.entity.UserEntity;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
