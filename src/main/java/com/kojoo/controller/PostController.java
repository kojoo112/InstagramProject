package com.kojoo.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kojoo.service.PostService;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/instagram/*")
public class PostController {
	
	@Inject
	PostService postService;
	
	@PostMapping("/like")
	public void like(HttpServletRequest req, MemberVO memberVo) {
	
	}
	
	@PostMapping("/posting")
	public String posting(HttpServletRequest req, PostVO postVo) {
		
		HttpSession session = req.getSession();
		log.info("session : " +  session);
				
		String uploadFolder = "/Users/kojoo112/eclipse-workspace/InstagramProject/src/main/webapp/resources/images/";
		
		log.info("posting................");
		
		   for(MultipartFile multipartFile : postVo.getImageFile()) {
			   log.info("upload File Name: " + multipartFile.getOriginalFilename());
			   log.info(multipartFile.getSize());
			   
			   File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			  
			   try {
				   multipartFile.transferTo(saveFile);
				   postVo.setPostImageName(saveFile.getName());
				   postService.register(postVo);
				   
			   } catch(Exception e){
				   log.error(e.getMessage());
				   return "fail";
			   }
		   }
		
		return "redirect:/instagram/myProfile";
	}

}
