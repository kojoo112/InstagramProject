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
	PostService service;
	
	@PostMapping("/posting")
	
	public String posting(MultipartFile[] imageName, HttpServletRequest req,
			String comment) {
		
		HttpSession session = req.getSession();
		log.info("session : " +  session);
		
		MemberVO vo = (MemberVO) session.getAttribute("member");
		log.info(vo.getMemberNo() + "MemberNo....................");
				
		String uploadFolder = "/Users/kojoo112/Desktop/temp/";
		
		log.info("posting................");
		
		   for(MultipartFile multipartFile : imageName) {
			   log.info("upload File Name: " + multipartFile.getOriginalFilename());
			   log.info(multipartFile.getSize());
			   
			   File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			  
			   try {
				   multipartFile.transferTo(saveFile);
				   
				   log.info("saveFile : " + saveFile);
				   log.info("getPath : " + saveFile.getPath());
				   log.info("getName : " + saveFile.getName());
				   
				   PostVO pvo = new PostVO(saveFile, comment, vo.getMemberNo());
				   
				   log.info(pvo);
				   service.register(pvo);
				   
			   } catch(Exception e){
				   log.error(e.getMessage());
				   return "fail";
			   }
		   }
		
		return "redirect:/instagram/myProfile";
	}

}
