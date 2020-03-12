package com.example.spring_first.model.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    @NotEmpty
    private String username;

    @Column(name="password")
    @NotEmpty
    private String password;

    @Column(name="email")
    private String email;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
