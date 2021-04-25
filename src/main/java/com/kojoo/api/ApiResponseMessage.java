package com.kojoo.api;

import lombok.Data;

@Data
public class ApiResponseMessage {

	private String status; 
	private String likeYn;
	private int count;
	private String errorMessage;
	private String errorCode;
	
	public ApiResponseMessage(String status, String likeYn, int count, String errorMessage, String errorCode) {
		
		this.status = status;
		this.likeYn = likeYn;
		this.count = count;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	
}
