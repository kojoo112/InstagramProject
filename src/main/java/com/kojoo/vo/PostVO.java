package com.kojoo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostVO {
	
	private int pno;
	private String imageName;
	private String comment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date regDate;
	
}
