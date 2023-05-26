package com.hyundai.thepet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping(value = "reservation")
	public String Test() {
		return "reservation/reservation";
	}
}
