package com.hyundai.thepet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"loginId"})
public class TestController {
	
	@ModelAttribute(value = "loginId")
	public int createLoginId() {
		return 0;
	}
	
	@GetMapping(value = "reservation")	
	public String Test(Model model) {
		model.addAttribute("loginId", 1);
		return "reservation/reservation"; 
	}
}
