package com.kojoo.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	@GetMapping("/main")
	public void main() {
		log.info("Logaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa............................");
		System.out.println("sysoutAaaaaaaaaaaaaaaaaaaaaaaa..............");
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public void getSignUp() {	
	}
	
	
	@GetMapping("/home")
	public String home(Locale locale, Model model) throws Exception {
		List<MemberVO> memberList = service.selectMember();
		model.addAttribute("member", memberList);
		
		return "/home";
	}

}
