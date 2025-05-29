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

import com.example.demo.model.UserSAL;
import com.example.demo.service.AdminSalService;

@RestController
@RequestMapping("/api/admin/usersal")
public class AdminUserSALController {
	@Autowired
	private AdminSalService adminSalService;
	
	@PostMapping("/save")
	public ResponseEntity<String> userSALInsert(@RequestBody UserSAL userSAL, 
			@RequestHeader("Authorization") String authHeader,
			@RequestHeader(value = "Role", required = false) String role) {
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 토큰이 없습니다.");
	    }
		
		if(!"ADMIN".equals(role)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("관리자 권한이 아닙니다.");
		}
		
		adminSalService.userSalInsert(userSAL);
		return ResponseEntity.ok("급여명세서가 등록되었습니다.");
	}
	
	@GetMapping("/selectsal")
	public UserSAL selectUserSALInfo(String userid, String year_month) {
		return adminSalService.selectUserSALInfo(userid, year_month);
	}
}
