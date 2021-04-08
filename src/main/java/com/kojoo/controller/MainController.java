package com.kojoo.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		log.info("asdf...........................");
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
	public String home(@ModelAttribute("email") String email) throws Exception {
		
		log.info(email);
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
		}
		
		log.info("login............" + login);
		
		return "/instagram/main";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/instagram/index";
	}
	
	
	

}
