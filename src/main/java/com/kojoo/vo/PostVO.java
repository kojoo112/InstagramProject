package com.kojoo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class PostVO {
	
	private int postNo;
	private MultipartFile[] imageFile;
	private String postImageName;
	private String comment;
	private int memberNo;
	private String profileImageName;
	private String userName;
	private int likeCount;
	private String likeYn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
}
