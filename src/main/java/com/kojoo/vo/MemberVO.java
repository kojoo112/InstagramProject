package com.kojoo.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.cj.jdbc.Blob;

import lombok.Data;

@Data
public class MemberVO {
	
	private String email;
	private String username;
	private String password;
	private Blob image;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	

}
