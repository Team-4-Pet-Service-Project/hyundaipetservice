package com.hyundai.thepet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hyundai.thepet.member.vo.MemberVO;

public class AuthInterceptor implements HandlerInterceptor {

	Logger log = LogManager.getLogger("case3");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.debug("인터셉터 진입");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		log.debug("예약 페이지");
		log.debug(session);
		log.debug("인터셉터 호출 : " + member);
		
		if (member == null) {
			log.debug("리다이렉트 부분");
			response.sendRedirect("/thepet/member/login");
			return false;
		}
		return true;
	}

}
