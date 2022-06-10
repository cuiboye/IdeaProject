package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * JpaRepository<实体类,主键类型>we
 */
public interface UserEntityRepository extends JpaRepository<UserEntity,Integer>, JpaSpecificationExecutor<UserEntity> {
//    自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称
//    按照Spring Data的规范，查询方法以find | read | get 开头，涉及查询条件时，条件的属性用条件关键字连接，要注意的是：条件属性以首字母大写。
//    Spring Data JPA框架在进行方法名解析时，会先把方法名多余的前缀截取掉
    List<UserEntity> findByUserid(Integer code);
    List<UserEntity> findAll();
    UserEntity saveAndFlush(UserEntity userEntity);
}
