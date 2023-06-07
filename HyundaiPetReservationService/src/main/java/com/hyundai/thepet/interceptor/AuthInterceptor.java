package com.hyundai.thepet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class AuthInterceptor implements HandlerInterceptor {

	Logger log = LogManager.getLogger("case3");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.debug("인터셉터 진입");
		
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect("/thepet/member/login");
			return false;
		}
		return true;
	}

}
