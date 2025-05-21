package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.model.Attendance;
import com.example.demo.model.AttendanceType;

@Service
public class AttendanceService {
	@Autowired
    private AttendanceMapper attendanceMapper;

    public void saveAttendance(Attendance attendance) {
        attendanceMapper.insertAttendance(attendance);
    }
    
    public List<Attendance> getAttendanceByUserAndMonth(String userid, int year, int month) {
        return attendanceMapper.selectAttendanceByUserAndMonth(userid, year, month);
    }
    
    public List<AttendanceType> getAllAttendanceTypes() {
        return attendanceMapper.selectAllAttendanceTypes();
    }
}
