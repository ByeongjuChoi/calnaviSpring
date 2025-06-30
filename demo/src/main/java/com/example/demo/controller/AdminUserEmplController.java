package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEmpl;
import com.example.demo.service.AdminEmplService;

@RestController
@RequestMapping("/api/admin/userempl")
public class AdminUserEmplController {
	@Autowired
	private AdminEmplService adminEmplService;
	
	@PostMapping("/save")
	public ResponseEntity<String> userEmplInsert(@RequestBody UserEmpl userEmpl, 
			@RequestHeader("Authorization") String authHeader,
			@RequestHeader(value = "Role", required = false) String role) {
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 토큰이 없습니다.");
	    }
		
		if(!"ADMIN".equals(role)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("관리자 권한이 아닙니다.");
		}
		
		adminEmplService.userEmplInsert(userEmpl);
		return ResponseEntity.ok("就業条件明示書が登録されました。");
	}
	
	@GetMapping("/selectempl")
	public UserEmpl selectUserEmplInfo(String userid, String year_month) {
		return adminEmplService.userEmplSelect(userid, year_month);
	}
}
