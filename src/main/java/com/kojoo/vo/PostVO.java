package com.kojoo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostVO {
	
	private int id;				// pk
	private String comment;		// fk
	private int heart;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	
	private String fileName;
	private int fileSize;
	private String fileType;
	

}
