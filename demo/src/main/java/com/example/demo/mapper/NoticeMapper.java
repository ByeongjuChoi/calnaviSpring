package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.MainNotice;
import com.example.demo.model.Notice;
import com.example.demo.model.WriteNotice;

public interface NoticeMapper {
	List<Notice> getAllNotices(int id);	// 전체 공지 조회
	List<MainNotice> getMainNotices(String MainOrAll);	// 메인페이지 공지 조회
	
	void insertNotices(WriteNotice writeNotice);
	void deleteNotice(WriteNotice writeNotice);
}
