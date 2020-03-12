package com.example.spring_first.dto.response;

import com.example.spring_first.dto.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserResponse extends BaseResponse {

    private List<User> users;

    public UserResponse(String status, Integer code) {
        super(status, code);
    }

    public UserResponse(String status, Integer code, List<User> users){
        super(status, code);
        this.users = users;
    }
    public UserResponse(String status, Integer code, User user){
        super(status, code );
        List<User> userList = new ArrayList<>();
        userList.add(user);
        this.users = userList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
