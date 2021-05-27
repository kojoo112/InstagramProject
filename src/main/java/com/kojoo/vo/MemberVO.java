package com.kojoo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberVO {
	
	private int memberNo;
	private String email;
	private String userName;
	private String password;
	private String imageName;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
}
