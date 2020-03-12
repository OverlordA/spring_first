package com.example.spring_first.repository;

import com.example.spring_first.model.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends CrudRepository<UserEntity, Long>{

    List<UserEntity> findAllBy();

    UserEntity findByUsername(String username);

    Optional<UserEntity> findById(Long id);

}
