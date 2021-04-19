package com.kojoo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class LikeVO {
	private int postIndex;
	private int memberIndex;
	private Date regDate;
}
