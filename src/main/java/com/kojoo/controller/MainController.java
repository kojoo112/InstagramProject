package com.kojoo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kojoo.service.MemberService;
import com.kojoo.service.PostService;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/instagram/*")
public class MainController {

	@Inject
	private MemberService memberService;
	
	@Inject
	private PostService postService;
	
	
	
	@GetMapping("/index")
	public void index() {
	}
	
	@GetMapping("/signUp")
	public void getSignUp() {	
	}
	
	@PostMapping("/signUp")
	public String postSignUp(MemberVO memberVo) {
		
		memberService.register(memberVo);
		
		return "redirect:/instagram/index";
	}
	
	@PostMapping("/login")
	public String postLogin(MemberVO vo, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		MemberVO login = memberService.login(vo);
		
		if(login == null) {
			log.info("login Failed..........");
			
			return "/instagram/loginFailed";
			
		} else {
			session.setAttribute("member", login);
			String uploadPath = "/resources/img/";
			login.setImageName(uploadPath + login.getImageName());
		}
		
		log.info("login............" + login);
		
		return "redirect:/instagram/main";
	}
	
	@GetMapping("/main")
	public String main(MemberVO memberVo, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		memberVo = (MemberVO) session.getAttribute("member");
		log.info(memberVo.getMemberNo());
		log.info("main.................");
		log.info(memberVo);
		
		List<PostVO> postList = postService.feedReading(memberVo);
		model.addAttribute("postList", postList);
//		List<LikeVO> likeList = postService.likeSelect(6);
		
		return "/instagram/main";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/instagram/index";
	}
	
	@GetMapping("/{member.userName}")
	public String myProfile(MemberVO memberVo, HttpServletRequest req) {
		HttpSession session = req.getSession();
		log.info("getRequestURL : " + req.getRequestURL());
		
		memberVo = (MemberVO) session.getAttribute("member");
		List<PostVO> list = postService.myPosting(memberVo);
		req.setAttribute("lists", list);
		
		log.info(memberVo.getMemberNo()+ "memberNo.............");
		log.info("getURI" + req.getRequestURI());
		
		return "/instagram/myProfile";
	}
	
	@GetMapping("/uploadFile")
	public String formFile() {
	    return "/instagram/uploadFile";
	}
		     
}
