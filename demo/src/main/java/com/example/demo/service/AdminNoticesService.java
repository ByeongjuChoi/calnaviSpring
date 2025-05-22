package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.NoticeMapper;
import com.example.demo.model.WriteNotice;

@Service
public class AdminNoticesService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public void insertNotices(WriteNotice writeNotice) {
		noticeMapper.insertNotices(writeNotice);
	}
	
	public void deleteNotice(WriteNotice writeNotice) {
		noticeMapper.deleteNotice(writeNotice);
	}
}
