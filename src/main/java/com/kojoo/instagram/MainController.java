package com.kojoo.instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/instagram/*")
public class MainController {

	
	@GetMapping("/asd")
	public void asd() {
		log.info("asdfasdf");
	}


}
