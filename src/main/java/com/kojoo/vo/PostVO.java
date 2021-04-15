package com.kojoo.vo;

import java.io.File;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostVO {
	
	private int postNo;
	private String imageName;
	private String comment;
	private int memberNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;

	public PostVO(File imageName, String comment, int memberNo) {
		this.imageName = imageName.getName();
		this.comment = comment;
		this.memberNo = memberNo;
	}
	
	
}
