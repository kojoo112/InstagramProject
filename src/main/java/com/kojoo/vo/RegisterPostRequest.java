package com.kojoo.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RegisterPostRequest {
	private PostVO pvo;
	private MultipartFile imageName;
}
