package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.NoticeMapper;
import com.example.demo.model.MainNotice;
import com.example.demo.model.Notice;

@Service
public class MainService {
	@Autowired
    private NoticeMapper noticeMapper;
	
	// 공지사항 전체 조회
	public List<Notice> getNotices(int id) {
        return noticeMapper.getAllNotices(id);
	}
	
	// 메인페이지 전체 조회
	public List<MainNotice> getMainNotices(String MainOrAll) {
        return noticeMapper.getMainNotices(MainOrAll);
	}
}
