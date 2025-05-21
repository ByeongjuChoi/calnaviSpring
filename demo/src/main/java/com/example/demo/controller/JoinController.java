package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.JoinService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class JoinController {
	
	@Autowired
    private JoinService joinService;

	// 회원가입 처리
    @PostMapping("/join")
    public String joinProcess(@RequestBody User user) {
    	boolean result = joinService.JoinProcess(user);
        return result ? "success" : "fail";
    }
    
    // 이 부분 추가: OPTIONS 요청 핸들러
//    @RequestMapping(value = "/join", method = RequestMethod.OPTIONS)
//    public void handleOptions() {
//        // Spring Security의 CorsConfigurationSource 설정에 따라 자동으로 CORS 헤더가 포함된 응답이 나가게 됨
//    }
}
