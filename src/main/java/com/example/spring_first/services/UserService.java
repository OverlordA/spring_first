package com.example.spring_first.services;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.User;
import com.example.spring_first.models.dto.RegisterUserRequest;
import com.example.spring_first.models.dto.UserResponse;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepo userRepo;

    @Autowired
    public UserService(UsersRepo userRepo){
        this.userRepo = userRepo;
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

    public UserResponse getUser(Long id ) {
        UserResponse userResponse = new UserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS);
        Optional<UserEntity> userOptional = userRepo.findById(id);
        UserEntity user = Optional.ofNullable(userOptional).map( value -> value.get()).orElse( new UserEntity());
        List<User> user1 = new ArrayList<>();
        user1.add(new User(user.getId(),user.getUsername(), user.getEmail()));
        userResponse.setUsers(user1);
        return userResponse;
    }

}
