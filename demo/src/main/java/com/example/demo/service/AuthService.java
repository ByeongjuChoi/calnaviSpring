package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;

@Service
public class AuthService {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(User user) {
        User dbUser = userMapper.findByUsername(user.getUserid());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return jwtUtil.generateToken(dbUser.getUserid(), dbUser.getRole());
        }
        return null;
    }
}
