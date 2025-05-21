package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class AdminUserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findByAllUsers() {
		return userMapper.findByAllUsers();
	}
	
	public void updateUserName(User user) {
		userMapper.updateUserName(user);
	}
}
