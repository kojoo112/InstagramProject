package com.kojoo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostVO {
	
	private int postNo;
	private MultipartFile[] imageFile;
	private String imageName;
	private String comment;
	private int memberNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;

	
	
}
