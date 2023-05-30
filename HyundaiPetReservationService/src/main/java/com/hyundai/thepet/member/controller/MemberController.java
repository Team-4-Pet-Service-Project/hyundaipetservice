package com.hyundai.thepet.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyundai.thepet.member.service.MemberService;
import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@RequestMapping(value = "member")
// @SessionAttributes(value = { "member" })
public class MemberController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	MemberService service;

	@PostMapping(value = "register")
	public String register(MemberVO member, RedirectAttributes rttr) {

		log.debug("register method : " + member);
		service.register(member);
		rttr.addFlashAttribute("member", member);

		return "redirect:/member/registerResult";
	}
	
	@PostMapping(value="checkId")
	@ResponseBody
	public String checkId(String email) {
		
		log.debug("check id..... :  " + email);
		
		String result = service.checkId(email);
		
		log.debug("check id result : " + result);
		
		return result;
	}
	
	
	
	@PostMapping(value = "login")
	public String login(@ModelAttribute("member") MemberVO member, Model model) {

		log.debug("login method : " + member);

		MemberVO result = service.login(member);
		
		log.debug(result);

		// 세션에 값 넣기
		model.addAttribute(result);
		
		String viewName = "";
		if (result.getEmail() != "") {
			model.addAttribute(member);
			viewName = "member/html/login.html";
		} else {
			viewName = "redirect:/member/html/login.html";
		}
		log.debug(viewName);
		return viewName;
	}

	
	
	@GetMapping(value = "register_bt")
	public String register_bt() {
		return "member/register";
	}

	@GetMapping(value = "login_bt")
	public String logint_bt() {
		return "member/login";
	}
	
	@GetMapping(value = "register_complete_bt")
	public String register_complete_bt() {
		return "member/registerResult";
	}

}
