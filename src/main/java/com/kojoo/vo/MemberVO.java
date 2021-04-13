package com.kojoo.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	
	private int mno;
	private String email;
	private String userName;
	private String password;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date regDate;
	
	private String imageName;

	

}
