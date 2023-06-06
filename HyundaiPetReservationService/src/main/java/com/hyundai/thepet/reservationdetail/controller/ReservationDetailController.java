package com.hyundai.thepet.reservationdetail.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.message.controller.SmsController; 
import com.hyundai.thepet.message.vo.ReservationVO;

@Controller
@RequestMapping(value = "reservation")
public class ReservationDetailController {
	
	Logger log = LogManager.getLogger("case3");
	
	private final SmsController smsController; 
    public ReservationDetailController(SmsController smsController) 
    { this.smsController = smsController; }
	
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
	public String reservDelete(ReservationDetailVO reservationDetailVO) throws InvalidKeyException, JsonProcessingException, UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
		
		ReservationVO reservation = new ReservationVO();
		reservation.setReservationId(reservationDetailVO.getReservationId());
		smsController.cancelMessage(reservation);
		
		
		service.reservationDelete(reservationDetailVO);
		
		
		return "/thepet/mypage/reservlist";
	}
}
