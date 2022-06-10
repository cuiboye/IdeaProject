package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层
 */
@Service
public interface UserEntityService {
    List<UserEntity> findByUserid(Integer code);
    List<UserEntity> findAll();
    String saveAndFlush(UserEntity userEntity);
}
