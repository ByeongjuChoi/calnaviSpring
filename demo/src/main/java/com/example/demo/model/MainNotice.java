package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MainNotice {

	private int id;
    private String title;
    private String content;
    private LocalDateTime updatedAt;
}
