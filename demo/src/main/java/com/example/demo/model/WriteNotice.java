package com.example.demo.model;

import lombok.Data;

@Data
public class WriteNotice {
	private Long id;
	private String title;
	private String contents;
	private String userid;
}
