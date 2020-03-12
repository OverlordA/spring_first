package com.example.spring_first.service;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.dto.model.User;
import com.example.spring_first.dto.response.LoginUserRequest;
import com.example.spring_first.dto.response.LoginUserResponse;
import com.example.spring_first.dto.response.RegisterUserRequest;
import com.example.spring_first.dto.response.UserResponse;
import com.example.spring_first.model.dao.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AuthService {

    private final UsersRepo usersRepo;
    private final HashService hashService;
    private final JwtService jwtService;

    @Autowired
    public AuthService(UsersRepo usersRepo, HashService hashService, JwtService jwtService){
        this.usersRepo = usersRepo;
        this.hashService = hashService;
        this.jwtService = jwtService;
    }

    public LoginUserResponse loginUser(LoginUserRequest request) throws NoSuchAlgorithmException {
       UserEntity user = usersRepo.findByUsername(request.getUsername());
       String requestHas = hashService.calculateHash(request.getPassword());
       if(requestHas.equals(user.getPassword())){
           String token = jwtService.calculateJWT(new User(user), requestHas);
           return new LoginUserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS, token);
       }else{
           return new LoginUserResponse(ResponseStatus.ERROR_STATUS, ResponseStatusCode.AUTH_FAILURE);
       }
    }
    public UserResponse registerUser(RegisterUserRequest userRequest) throws NoSuchAlgorithmException {
        String passwordHash = hashService.calculateHash(userRequest.getPassword());
        UserEntity receivedUser = new UserEntity(userRequest.getUsername(), passwordHash, userRequest.getEmail());
        UserEntity createdUser = usersRepo.save(receivedUser);
        User respondedUser =  new User(createdUser);
        return new UserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS, respondedUser);
    }

}
