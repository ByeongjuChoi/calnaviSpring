package com.example.demo.model;

import lombok.Data;

@Data
public class UserAttendanceInfo {
	private String userid;				// 유저 아이디
	private String username;			// 유저 닉네임
	private Integer attendance_cnt;		// 근무 일수
	private String attendance_alltime;	// 근무 총 시간
	private Double used_vacation;		// 사용한 휴일
	private Double vacation;			// 휴일
	private Integer absent;				// 결석 일수
	private Integer workdays;			// 평일 일수
}
