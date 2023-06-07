package com.hyundai.thepet.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hyundai.thepet.interceptor.annotation.Auth;
import com.hyundai.thepet.member.service.MemberService;
import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@RequestMapping(value = "member")
@SessionAttributes(value = { "member" })
public class MemberController {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	MemberService service;

	/*
	 * @ModelAttribute(value = "member") public MemberVO setMemberVO() { return new
	 * MemberVO(0, "", "", "", "", "", 0, ""); }
	 */

	@PostMapping(value = "register")
	public String register(MemberVO member, Model model) {

		log.debug("register method : " + member);

		member.setBirth(member.getBirth().split(",")[0]);
		log.debug("controller register : birth " + member.getBirth());
		System.out.println("controller birth :   " + member.getBirth());

		service.register(member);
		return "/member/registerResult";
	}

	@PostMapping(value = "checkId")
	@ResponseBody
	public String checkId(String email) {

		log.debug("check id..... :  " + email);
		String result = service.checkId(email);
		log.debug("check id result : " + result);

		return result;
	}

	@PostMapping(value = "checkPhone")
	@ResponseBody
	public String checkPhone(String phone) {

		log.debug("check id..... :  " + phone);
		String result = service.checkPhone(phone);
		log.debug("check id result : " + phone);

		return result;
	}

	@Auth
	@PostMapping(value = "login")
	@ResponseBody
	public ResponseEntity<MemberVO> login(MemberVO member, Model model) throws Exception {

		log.debug("login method : " + member);
		MemberVO result = service.login(member);
		log.debug("controller : " + result);

		try {
			if (result == null) {
				return new ResponseEntity<MemberVO>(result, HttpStatus.UNAUTHORIZED);
			} else {
				model.addAttribute("member", result);
				return new ResponseEntity<MemberVO>(result, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "register")
	public String registerBt() {

		return "member/register";
	}

	@GetMapping(value = "login")
	public String logintBt() {
		return "member/login";
	}

	@GetMapping(value = "register_complete_bt")
	public String registerCompleteBt() {
		return "member/registerResult";
	}

	@GetMapping(value = "logout")
	public String logout(SessionStatus sessionStatus) {
		
		log.info("logout 실행");
		sessionStatus.setComplete();
		
		return "redirect:/main";
	}
}
