package com.hyundai.thepet.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hyundai.thepet.member.service.MemberService;
import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@SessionAttributes(value= {"member"})
public class MemberController {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	MemberService service;

	@PostMapping(value = "register")
	public String register(MemberVO member) {

		log.debug("register method : " + member);

		boolean result = service.register(member);

		String viewName = "";
		if (result) {
			viewName = "member/html/login.html";
		} else {
			viewName = "redirect:/member/html/home.html";
		}

		log.debug(viewName);

		return viewName;
	}

	@GetMapping(value="login")
	public String login(@ModelAttribute("member") MemberVO member, Model model) {
		
		log.debug("login method : " + member);

		boolean result = service.login(member);
		
		String viewName = "";
		if (result) {
			model.addAttribute(member);
			viewName = "member/html/login.html";
		} else {
			viewName = "redirect:/member/html/login.html";
		}

		log.debug(viewName);

		return viewName;
	}
	
	@GetMapping(value="register_bt")
	public String register_bt() {
		return "member/register";
	}
	
	@GetMapping(value="login_bt")
	public String logint_bt() {
		return "member/login";
	}
	
}
