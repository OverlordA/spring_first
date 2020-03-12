package com.example.spring_first.service;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.exception.BaseException;
import com.example.spring_first.dto.model.User;
import com.example.spring_first.dto.response.UserResponse;
import com.example.spring_first.model.dao.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try{
            Optional<UserEntity> userOptional = userRepo.findById(id);
            UserEntity user = Optional.ofNullable(userOptional).map( value -> value.get()).orElse( new UserEntity());
            List<User> user1 = new ArrayList<>();
            user1.add(new User(user.getId(),user.getUsername(), user.getEmail()));
            userResponse.setUsers(user1);
            return userResponse;
        }catch (Exception ex) {
            throw new BaseException("User is not found ! ");
        }
    }

}
