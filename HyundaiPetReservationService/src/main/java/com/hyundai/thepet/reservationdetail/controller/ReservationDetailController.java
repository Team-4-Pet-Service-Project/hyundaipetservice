package com.hyundai.thepet.reservationdetail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.thepet.reservationdetail.service.ReservationDetailService;
import com.hyundai.thepet.reservationdetail.vo.ReservationDetailVO;
import com.hyundai.thepet.review.vo.ReviewVO;

@Controller
@RequestMapping(value = "reservation")
public class ReservationDetailController {
	
	Logger log = LogManager.getLogger("case3");
	
	
	@Autowired
	ReservationDetailService service;
	
	@GetMapping(value = "detail")
	public String reservationDetail(ReservationDetailVO reservaiontDetailVO,Model model){
		ReservationDetailVO vo = service.infoPrint(reservaiontDetailVO);
		model.addAttribute("Reservationdetail",vo);
		return "reservationdetail/reservationdetail";
	}
	
	@GetMapping(value = "delete")
	@ResponseBody
	public String reservDelete(ReservationDetailVO reservationDetailVO) {
		service.reservationDelete(reservationDetailVO);
		return "/thepet/mypage/reservlist";
	}
}
