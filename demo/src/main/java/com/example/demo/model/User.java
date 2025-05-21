package com.example.demo.model;

import lombok.Data;

@Data
public class User {
	
	private String userid;
    private String username;
    private String password;
    private String role; // 추가
}
