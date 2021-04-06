package com.kojoo.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	private String email;
	private String username;
	private String password;
	private Date regDate;
	

}
