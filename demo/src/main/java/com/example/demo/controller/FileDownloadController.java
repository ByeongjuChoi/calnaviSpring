package com.example.demo.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api/files")
public class FileDownloadController {

	@GetMapping("/download/{type}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String type) throws IOException {
	    String filename;
	    String contentType;

	    switch (type) {
	        case "keihi":
	            filename = "file/経費精算書.xlsx";
	            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	            break;
	        case "tuukinteate":
	            filename = "file/通勤手当支給（変更）申請書.xlsx";
	            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	            break;
	        case "kyuyosodok":
	            filename = "file/【見本】令和7年分 給与所得者の扶養控除等（異動）申告書.pdf";
	            contentType = "application/pdf";
	            break;
	        case "keihisyanai":
	            filename = "file/【入力見本】（社内用）経費精算書.pdf";
	            contentType = "application/pdf";
	            break;
	        case "kyuyosodokmihon":
	            filename = "file/令和7年分 給与所得者の扶養控除等（異動）申告書.pdf";
	            contentType = "application/pdf";
	            break;
	            
	        case "nyusyaannai":
	            filename = "file/入社時の手引き.pdf";
	            contentType = "application/pdf";
	            break;
	        case "kintaimenu":
	            filename = "file/CALNAVI勤怠入力マニュアル.pdf";
	            contentType = "application/pdf";
	            break;
	        case "teleworktate":
	            filename = "file/テレワーク手当・通勤ルート入力マニュアル.pdf";
	            contentType = "application/pdf";
	            break;
	        case "syushokusisai":
	            filename = "file/就業時の心構え及びその他基本情報.pdf";
	            contentType = "application/pdf";
	            break;
	        case "calender":
	            filename = "file/CAL-2025カレンダー.pdf";
	            contentType = "application/pdf";
	            break;
	        case "hulurikousei":
	            filename = "file/福利厚生（プログラミングサイトのご案内）.pdf";
	            contentType = "application/pdf";
	            break;
	            
	        case "kouza":
	            filename = "file/口座振込依頼書.docx";
	            contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	            break;
	        default:
	            return ResponseEntity.badRequest().build();
	    }

	    ClassPathResource file = new ClassPathResource(filename);

	    if (!file.exists()) {
	        return ResponseEntity.notFound().build();
	    }

	    String downloadFileName = URLEncoder.encode(file.getFilename(), StandardCharsets.UTF_8)
	        .replaceAll("\\+", "%20");

	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(contentType))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + downloadFileName)
	            .body(file);
	}
}
