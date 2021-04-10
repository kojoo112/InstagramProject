package com.kojoo.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.kojoo.dao.MemberDAO;
import com.kojoo.service.MemberService;
import com.kojoo.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/instagram/*")
public class MainController {

	@Inject
	private MemberService service;
	
	
	@GetMapping("/index")
	public String index() {
		
		return "/instagram/index";
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public void getSignUp() {	
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String postSignUp(MemberVO vo) {
		
		service.register(vo);
		
		return "redirect:/instagram/index";
	}
	
	
	@GetMapping("/home")
	public String home() throws Exception {
		
		return "/home";
	}
	
	@PostMapping("/login")
	public String postLogin(MemberVO vo, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			log.info("login Failed..........");
			
			return "/instagram/loginFailed";
			
		} else {
			session.setAttribute("member", login);
			String uploadPath = "/resources/img/";
			login.setImagePath(uploadPath + login.getImagePath());
		}
		
		log.info("login............" + login);
		
		return "/instagram/main";
	}
	
	public void main(MemberVO vo) {
		service.read(vo);
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/instagram/index";
	}
	
	@GetMapping("/profile")
	public String myProfile(MemberVO vo) {
		
		return "/instagram/myProfile";
	}
	
	
	@RequestMapping(value="/uploadFile")
	public String formFile() {
	    return "/instagram/uploadFile";
	}
	 
	/**
	 * 파일처리 컨트롤러
	 * @param vo
	 * @return
	 */
	@PostMapping(value="/saveImage")
	public void saveImage(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "/Users/kojoo112/Desktop/temp/";
		
		
	   for(MultipartFile multipartFile : uploadFile) {
		   log.info("upload File Name: " + multipartFile.getOriginalFilename());
		   log.info(multipartFile.getSize());
		   
		   File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
		   
		   String uploadImagePath = uploadFolder + multipartFile.getOriginalFilename();
		   
		   try {
			   multipartFile.transferTo(saveFile);
			   log.info(uploadImagePath);
		   } catch(Exception e){
			   log.error(e.getMessage());
		   }
	   }
	   
	}
	
	@PostMapping("/postingForm")
	public String posting(MultipartFile[] uploadFile, Model model, MemberVO vo) {
		
		String uploadFolder = "/Users/kojoo112/Desktop/temp/";
		
		
		   for(MultipartFile multipartFile : uploadFile) {
			   log.info("upload File Name: " + multipartFile.getOriginalFilename());
			   log.info(multipartFile.getSize());
			   
			   File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			   
			   String uploadImagePath = uploadFolder + multipartFile.getOriginalFilename();
			   vo = service.login(vo);
			   try {
				   multipartFile.transferTo(saveFile);
				   log.info("uploadImagePath" + uploadImagePath);
				   log.info("saveFile" +saveFile);
				   
			   } catch(Exception e){
				   log.error(e.getMessage());
			   }
		   }
		
		return "redirect:/instagram/profile";
	}

	
	@RequestMapping(value="/view")
	public String view(MemberVO vo) {
		
		String uploadPath = "/Users/kojoo/Desktop/temp/";
		String imagePath = uploadPath + vo.getImagePath();
		
		
		
				
	    return "/instagram/view";
	}
	     
}