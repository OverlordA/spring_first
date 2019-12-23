package com.example.spring_first.services;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.RegisterUserRequest;
import com.example.spring_first.models.dto.UserResponse;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UsersRepo userRepo;
    private final HashService hashService;

    @Autowired
    public UserService(UsersRepo userRepo, HashService hashService){
        this.userRepo = userRepo;
        this.hashService = hashService;
    }


    public UserResponse registerUser(RegisterUserRequest userRequest) throws NoSuchAlgorithmException {
        String passwordHash = hashService.calculateHash(userRequest.getPassword());
        UserEntity receivedUser = new UserEntity(userRequest.getUsername(), passwordHash, userRequest.getEmail());
        UserEntity createdUser = userRepo.save(receivedUser);
        User respondedUser =  new User(createdUser);
        return new UserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS, respondedUser);
    }

    public UserResponse getAllUser(){
        UserResponse userResponse = new UserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
        List<UserEntity> users = userRepo.findAllBy();
        List<User> users1 = new ArrayList<>();
        users.forEach((u) -> users1.add(
                new User(u.getId(),u.getUsername(), u.getEmail()))
        );
        userResponse.setUsers(users1);
        return userResponse;
    }

}
