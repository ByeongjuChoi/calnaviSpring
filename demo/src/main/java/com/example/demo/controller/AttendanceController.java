package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Attendance;
import com.example.demo.model.AttendanceType;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

	@Autowired
    private AttendanceService attendanceService;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@GetMapping("/selectM")
	public List<Attendance> getAttendanceByMonth(
	        @RequestParam int year,
	        @RequestParam int month,
	        @RequestHeader("Authorization") String authHeader
	) {
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return List.of(); // 또는 예외 처리
	    }

	    String token = authHeader.substring(7);
	    if (!jwtUtil.validateToken(token)) {
	        return List.of(); // 또는 예외 처리
	    }

	    String userid = jwtUtil.extractUsername(token);
	    return attendanceService.getAttendanceByUserAndMonth(userid, year, month);
	}

    @PostMapping("/save")
    public String saveAttendance(@RequestBody Attendance attendance, @RequestHeader("Authorization") String authHeader) {
    	if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return "토큰이 필요합니다.";
        }
    	
    	String token = authHeader.substring(7); // "Bearer " 제거
        if (!jwtUtil.validateToken(token)) {
            return "유효하지 않은 토큰입니다.";
        }
        
        String userid = jwtUtil.extractUsername(token); // subject에서 userid 추출
        attendance.setUserid(userid);

        attendanceService.saveAttendance(attendance);
        return "저장 완료";
    }
    
    @GetMapping("/getAttendanceType")
    public List<AttendanceType> getAllAttendanceTypes() {
        return attendanceService.getAllAttendanceTypes();
    }
}
