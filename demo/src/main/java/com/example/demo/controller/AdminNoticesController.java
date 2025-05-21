package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WriteNotice;
import com.example.demo.service.AdminNoticesService;

@RestController
@RequestMapping("/api/admin/notices")
public class AdminNoticesController {
	
	@Autowired
	private AdminNoticesService adminNoticesService;
	
	@PostMapping("/save")
	public ResponseEntity<String> insertNotices(@RequestBody WriteNotice writeNotice, 
			@RequestHeader("Authorization") String authHeader,
			@RequestHeader(value = "Role", required = false) String role) {
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 토큰이 없습니다.");
	    }
		
		if(!"ADMIN".equals(role)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("관리자 권한이 아닙니다.");
		}
		
		adminNoticesService.insertNotices(writeNotice);
		return ResponseEntity.ok("공지사항이 등록되었습니다.");
	}
}
