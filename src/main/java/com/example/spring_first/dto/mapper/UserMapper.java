package com.example.spring_first.dto.mapper;
import com.example.spring_first.dto.model.User;
import com.example.spring_first.model.dao.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class UserMapper {

        public static User toUserDto(UserEntity user) {
            return new User(user);
//            return new User()
//                    .setEmail(user.getEmail())
//                    .setFirstName(user.getFirstName())
//                    .setLastName(user.getLastName())
//                    .setMobileNumber(user.getMobileNumber())
//                    .setRoles(new HashSet<UserEntity>(user
//                            .getRoles()
//                            .stream()
//                            .map(role -> new ModelMapper().map(role, RoleDto.class))
//                            .collect(Collectors.toSet())));
        }
}
