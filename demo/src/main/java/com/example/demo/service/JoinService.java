package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class JoinService {
	
	@Autowired
    private UserMapper userMapper;
	
	public boolean JoinProcess(User user) {
		// 유효성 검사
        if (user.getUserid() == null || user.getUserid().trim().isEmpty() ||
            user.getPassword() == null || user.getPassword().trim().isEmpty() ||
            user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return false;
        }
        
        // DB에 삽입
        userMapper.userInsert(user);
        return true;
        
	}
}
