package com.example.spring_first.services;

import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.RegisterUserRequest;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    private final UsersRepo userRepo;
    private final HashService hashService;

    @Autowired
    public UserService(UsersRepo userRepo, HashService hashService){
        this.userRepo = userRepo;
        this.hashService = hashService;
    }


    public User registerUser(RegisterUserRequest userRequest) throws NoSuchAlgorithmException {
        String passwordHash = hashService.calculateHash(userRequest.getPassword());
        UserEntity userEntity = new UserEntity(userRequest.getUsername(), passwordHash, userRequest.getEmail());
        userRepo.save(userEntity);
        return new User(userEntity.getUsername(), userEntity.getEmail());
    }
    public List<UserEntity> getAllUser(){
       return userRepo.findAllBy();
    }

}
