package com.kojoo.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO {
	
	private int memberNo;
	private String email;
	private String userName;
	private String password;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	
	private MultipartFile image;
	private String imagePath;

	

}
