package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> updateUserName(@RequestBody User user, @RequestHeader("Authorization") String authHeader) {
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization header missing or invalid");
	    }

	    String token = authHeader.substring(7);
	    if (!jwtUtil.validateToken(token)) {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
	    }
	    try {
	        adminUserService.updateUserName(user);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
	    }
	}
}
