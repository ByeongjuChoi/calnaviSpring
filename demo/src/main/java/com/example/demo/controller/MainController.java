package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MainNotice;
import com.example.demo.model.Notice;
import com.example.demo.service.MainService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/main")
@RequiredArgsConstructor
public class MainController {
	
	private final MainService mainService;
	
	@GetMapping("/Allnotices")
	public List<Notice> getNotices(@RequestParam("id") int id) {
		return mainService.getNotices(id);
	}
	
	@GetMapping("/Mainnotices")
	public List<MainNotice> getMainNotices(String MainOrAll) {
		return mainService.getMainNotices(MainOrAll);
	}
}
