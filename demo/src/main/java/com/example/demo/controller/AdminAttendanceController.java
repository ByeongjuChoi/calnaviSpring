package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserAttendanceInfo;
import com.example.demo.service.AttendanceService;

@RestController
@RequestMapping("/api/admin/attendance")
public class AdminAttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping("/selectUserAttendanceInfo")
	public List<UserAttendanceInfo> selectUserAttendanceInfo() {
		return attendanceService.selectUserAttendanceInfo();
	}
	
}
