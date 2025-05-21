package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/api")
public class TokenController {
	
	private final JwtUtil jwtUtil;
	
	public TokenController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
	
	// 토큰 남은 시간 확인 API
    @GetMapping("/token-remaining")
    public ResponseEntity<String> getTokenRemainingTime(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            long remainingMillis = jwtUtil.getRemainingtime(token);

            long minutes = remainingMillis / (1000 * 60);
            long seconds = (remainingMillis / 1000) % 60;

            return ResponseEntity.ok("남은 시간: " + minutes + "분 " + seconds + "초");
        }
        return ResponseEntity.badRequest().body("유효하지 않은 Authorization 헤더입니다.");
    }
}
