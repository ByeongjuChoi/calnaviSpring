package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;

import io.jsonwebtoken.Claims;

@RestController 
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) {
        User dbUser = userMapper.findByUsername(user.getUserid());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUserid(), dbUser.getRole());
            Claims claims = jwtUtil.extractAllClaims(token);
            
            //Map<String, String> responseData = new HashMap<>();
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("token", token);
            responseData.put("username", dbUser.getUsername());
            responseData.put("userid", user.getUserid());
            responseData.put("role", dbUser.getRole());
            responseData.put("issuedAt", claims.getIssuedAt().getTime());       // iat
            responseData.put("expiration", claims.getExpiration().getTime());   // exp

            return ResponseEntity.ok(responseData);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // 세션 무효화
        request.getSession().invalidate();

        // 쿠키 제거 등 필요 시 추가
        return ResponseEntity.ok().build();
    }
}
