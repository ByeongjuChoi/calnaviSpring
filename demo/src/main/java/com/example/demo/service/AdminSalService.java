package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserSALMapper;
import com.example.demo.model.UserSAL;

@Service
public class AdminSalService {
	@Autowired
    private UserSALMapper userSALMapper;
	
	public void userSalInsert(UserSAL usersal) {
		userSALMapper.userSalInsert(usersal);
	}
}
