package com.example.spring_first.services;

import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.RegisterUserRequest;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepo userRepo;

    @Autowired
    public UserService(UsersRepo userRepo){
        this.userRepo = userRepo;
    }


    public User registerUser(RegisterUserRequest userRequest){
        UserEntity userEntity = new UserEntity(userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail());
        userRepo.save(userEntity);
        return new User(userEntity.getUsername(), userEntity.getEmail());
    }

}
