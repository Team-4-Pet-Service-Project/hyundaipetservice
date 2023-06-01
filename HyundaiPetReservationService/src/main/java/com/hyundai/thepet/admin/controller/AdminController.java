package com.hyundai.thepet.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class AdminController {

	@GetMapping(value="main")
	public String adminMain() {
		return "admin/main";
	}
	
	
}
