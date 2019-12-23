package com.example.spring_first.services;

import com.example.spring_first.constants.ResponseStatus;
import com.example.spring_first.constants.ResponseStatusCode;
import com.example.spring_first.models.dto.LoginUserRequest;
import com.example.spring_first.models.dto.LoginUserResponse;
import com.example.spring_first.models.entity.UserEntity;
import com.example.spring_first.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AuthService {

    private final UsersRepo usersRepo;
    private final HashService hashService;

    @Autowired
    public AuthService(UsersRepo usersRepo, HashService hashService){
        this.usersRepo = usersRepo;
        this.hashService = hashService;
    }

    public LoginUserResponse loginUser(LoginUserRequest request) throws NoSuchAlgorithmException {
       UserEntity user = usersRepo.findByUsername(request.getUsername());
       String requestHas = hashService.calculateHash(request.getPassword());
       if(requestHas.equals(user.getPassword())){
           // todo generate token
           return new LoginUserResponse(ResponseStatus.SUCCESS_STATUS, ResponseStatusCode.CODE_SUCCESS, "token test");
       }else{
           return new LoginUserResponse(ResponseStatus.ERROR_STATUS, ResponseStatusCode.AUTH_FAILURE);
       }
    }
}
