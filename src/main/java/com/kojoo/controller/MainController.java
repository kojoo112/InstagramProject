package com.kojoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/instagram/*")
public class MainController {

	
	@GetMapping("/main")
	public void main() {
		log.info("Logaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa............................");
		System.out.println("sysoutAaaaaaaaaaaaaaaaaaaaaaaa..............");
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public void getSignUp() {	
	}
	
	
	@GetMapping("/home")
	public void home() {
		
	}

}
