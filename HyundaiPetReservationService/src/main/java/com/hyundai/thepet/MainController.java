package com.hyundai.thepet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hyundai.thepet.member.vo.MemberVO;

@Controller
public class MainController {
	@GetMapping(value = "main")
	public String mainController() {
		return "main/main";
	}
}


