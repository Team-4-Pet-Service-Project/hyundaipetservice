package com.hyundai.thepet.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@GetMapping(value="getMember", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public MemberVO getMemberInfo(@SessionAttribute(value = "member") MemberVO member) {
		return member;
	}
	
	@GetMapping(value = "")
	public String Test(Model model, @SessionAttribute(value = "member") MemberVO member) {	
		System.out.println("타나요!");
		model.addAttribute("member", member);
		return "reservation/reservation"; 
	}
}
