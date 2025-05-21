package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AdminUserService;

@RestController 
@RequestMapping("/api/admin")
public class AdminUserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AdminUserService adminUserService;
	
	@GetMapping("/allusers")
	public List<User> findByAllUsers(@RequestHeader("Authorization") String authHeader) {
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return List.of(); // 또는 예외 처리
	    }

	    String token = authHeader.substring(7);
	    if (!jwtUtil.validateToken(token)) {
	        return List.of(); // 또는 예외 처리
	    }
		
		return adminUserService.findByAllUsers();
	}

	@PostMapping("updateusername")
	public void updateUserName(@RequestBody User user, @RequestHeader("Authorization") String authHeader) {
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return; // 또는 예외 처리
	    }

	    String token = authHeader.substring(7);
	    if (!jwtUtil.validateToken(token)) {
	        return; // 또는 예외 처리
	    }
	    adminUserService.updateUserName(user);
	}
}
