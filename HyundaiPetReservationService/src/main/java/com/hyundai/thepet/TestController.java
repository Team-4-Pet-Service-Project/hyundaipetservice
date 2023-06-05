package com.hyundai.thepet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@SessionAttributes(value = {"member"})
public class TestController {
	
	@ModelAttribute(value = "member")
	public MemberVO createLoginId() {
		return new MemberVO();
	}
	
	@GetMapping(value = "reservation")	
	public String Test(Model model) {
		MemberVO member = new MemberVO();
		
		member.setId(3);
		member.setEmail("bedurgi999@gmail.com");
		member.setPhone("01092896143");
		member.setName("박보선");
		member.setBirth("96/01/26");
		member.setAdmin(0);
		
		model.addAttribute("member", member);
		return "reservation/reservation"; 
	}
	
	@GetMapping(value = "main")
	public String test2(Model model) {
		return "main/main";
	}
}


