package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Attendance {

	private String userid;
    private LocalDate date;
    private String type;
    private LocalTime start_Time;
    private LocalTime end_Time;
    private LocalTime leave_Time;
}
