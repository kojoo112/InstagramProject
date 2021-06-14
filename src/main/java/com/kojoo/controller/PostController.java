package com.kojoo.controller;

import com.kojoo.api.ApiResponseMessage;
import com.kojoo.service.PostService;
import com.kojoo.vo.LikeVO;
import com.kojoo.vo.PostVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@Log4j
@RequestMapping("/instagram/*")
public class PostController {
	
	@Inject
	PostService postService;
	
	@PostMapping("/like")
	@ResponseBody
	public ResponseEntity<ApiResponseMessage> like(HttpServletRequest req, LikeVO likeVo) {
		if (postService.getLikeCount(likeVo) == 0) {
			postService.likeInsert(likeVo);
			int count = postService.postLikeCount(likeVo);
			ApiResponseMessage like = new ApiResponseMessage("Success", "y", count, "", "");
			return new ResponseEntity<ApiResponseMessage>(like, HttpStatus.OK);
		} else {
			postService.deleteLike(likeVo);
			int count = postService.postLikeCount(likeVo);
			ApiResponseMessage like = new ApiResponseMessage("Success", "n", count, "", "");
			
			return new ResponseEntity<ApiResponseMessage>(like, HttpStatus.OK);
		}
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
