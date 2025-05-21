package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.model.User;
public interface UserMapper {
	
	User findByUsername(@Param("userid") String userid);
    void userInsert(User user);
    List<User> findByAllUsers();
    void updateUserName(User user); 
}
