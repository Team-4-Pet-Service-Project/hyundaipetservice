package com.hyundai.thepet.message;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.message.controller.SmsController;
import com.hyundai.thepet.message.vo.ReservationVO;


@Controller
@RequestMapping("smstest")
public class SmsTestController {
	
	private final SmsController smsController;
    public SmsTestController(SmsController smsController) {
        this.smsController = smsController;
    }
	
	@PostMapping("submit") // 예약하기 버튼 눌렀을 때 test (합칠 때 삭제)
	public void submitReservationAlarm(@ModelAttribute ReservationVO reservation) throws InvalidKeyException, JsonProcessingException, UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
		//예약 즉시 실행되는 로직
		smsController.submitMessage(reservation); // 이 줄만 추가하기 (reservationId는 필수로 있어야 함)
	}
	
	@PostMapping("cancel") // 예약취소 버튼 눌렀을 때 test (합칠 때 삭제)
	public void canceltReservationAlarm(@ModelAttribute ReservationVO reservation) throws InvalidKeyException, JsonProcessingException, UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
		//예약 즉시 실행되는 로직
		smsController.cancelMessage(reservation); // 이 줄만 추가하기 (reservationId는 필수로 있어야 함)
	}
	
	

}
