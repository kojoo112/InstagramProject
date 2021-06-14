package com.kojoo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LikeVO {
	private int postIndex;
	private int memberIndex;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
}
