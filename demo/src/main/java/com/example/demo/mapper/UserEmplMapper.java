package com.example.demo.mapper;

import com.example.demo.model.UserEmpl;

public interface UserEmplMapper {

	void userEmplInsert(UserEmpl userEmpl);
	UserEmpl userEmplSelect(String userid, String year_month);
}
