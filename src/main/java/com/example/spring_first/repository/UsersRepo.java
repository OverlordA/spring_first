package com.example.spring_first.repository;

import com.example.spring_first.models.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends CrudRepository<UserEntity, Long>{

    List<UserEntity> findAllBy();
}
