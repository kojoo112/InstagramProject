package com.kojoo.Interceptor;

import com.kojoo.vo.MemberVO;
import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j
public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO id = (MemberVO) session.getAttribute("member");
		
		if(null == id) {
			log.info("Interceptor : Session Check Fail");
			System.out.println("Interceptor : Session Check Fail"); // main page 로 이동 
			response.sendRedirect("/instagram/index");
			return false; 
		} else { 
			System.out.println("Interceptor : Session Check true"); 
			return super.preHandle(request, response, handler); 
		}
		
	}

}
