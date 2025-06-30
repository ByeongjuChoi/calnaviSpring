package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserEmplMapper;
import com.example.demo.model.UserEmpl;

@Service
public class AdminEmplService {
	
	@Autowired
	private UserEmplMapper userEmplMapper;
	
	public void userEmplInsert(UserEmpl userEmpl) {
		userEmplMapper.userEmplInsert(userEmpl);
	}
	
	public UserEmpl userEmplSelect(String userid, String year_month) {
		return userEmplMapper.userEmplSelect(userid, year_month);
	}

}
