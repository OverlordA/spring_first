package com.example.spring_first.models.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String username;

    public UserEntity() {
    }
}
