package com.hyundai.thepet.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// for test
public class MainTestController {

	@GetMapping(value = "main_reservation")
	public String Test() {
		return "main_reservation";
	}

}
