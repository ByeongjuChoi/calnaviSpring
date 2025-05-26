package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Attendance;
import com.example.demo.model.AttendanceType;
import com.example.demo.model.UserAttendanceInfo;

public interface AttendanceMapper {
	void insertAttendance(Attendance attendance);
	List<Attendance> selectAttendanceByUserAndMonth(@Param("userid") String userid, @Param("year") int year, @Param("month") int month);
	List<AttendanceType> selectAllAttendanceTypes();
	List<UserAttendanceInfo> selectUserAttendanceInfo(String month);
}