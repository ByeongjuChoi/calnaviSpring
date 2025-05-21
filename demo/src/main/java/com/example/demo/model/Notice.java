package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Notice {

	private int id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isPinned;
    private boolean isDeleted;
    private int viewCount;
}
