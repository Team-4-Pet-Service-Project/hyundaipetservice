package com.hyundai.thepet.admin.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.service.AdminService;
import com.hyundai.thepet.admin.vo.AdminVO;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private AdminService service;

	@GetMapping(value = "main")
	public String adminMain() {
		return "admin/main";
	}

	@PostMapping(value = "reservation")
	@ResponseBody
	public ResponseEntity<List<ReservationDTO>> adminReservationDetail(ReservationDTO reservation) throws Exception {
		
		log.debug("controller 진입 : reservation = " + reservation);
		List<AdminVO> result = service.getReservationDetail(reservation);
		try {
			if (result.isEmpty()) {
				return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return null;
		}
	}
}
