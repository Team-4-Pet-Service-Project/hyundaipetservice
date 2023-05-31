package com.hyundai.thepet.message.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.message.dto.MessageDTO;
import com.hyundai.thepet.message.dto.SmsResponseDTO;
import com.hyundai.thepet.message.service.SelectService;
import com.hyundai.thepet.message.service.SmsService;
import com.hyundai.thepet.message.vo.ReservationVO;
import java.sql.Date;
import java.text.SimpleDateFormat;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SmsController {
	private final SmsService smsService;
	private final SelectService selectService;


	// 예약 즉시
	public SmsResponseDTO submitMessage(ReservationVO reservation) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
		
		ReservationVO reserv = selectService.selectReservation(reservation.getReservationId());
		
		String phone = selectService.selectPhone(reserv.getMemberId());
		String name = selectService.selectName(reserv.getMemberId());
		String location_facility = selectService.selectFacility(reserv.getLocationId());
		Date reservationDate = reserv.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);
		
		String content = name + "님, "+ reservationDateString + " " + reserv.getReservationStartTime() + "에 "
    			+ location_facility + "가 예약되었습니다.";
		
		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);
		
		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;
		
	}


	// 예약 취소
	public SmsResponseDTO cancelMessage(ReservationVO reservation) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {

		ReservationVO reserv = selectService.selectReservation(reservation.getReservationId());

		String phone = selectService.selectPhone(reserv.getMemberId());
		String name = selectService.selectName(reserv.getMemberId());
		String location_facility = selectService.selectFacility(reserv.getLocationId());
		Date reservationDate = reserv.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);

		String content = name + "님, "+ reservationDateString + " " + reserv.getReservationStartTime() + "에 예약하신 "
    			+ location_facility + " 예약이 취소되었습니다.";

		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);

		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;

	}
	
	// 예약 10분 전
	public SmsResponseDTO scheduledMessage(ReservationVO reservation) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
		ReservationVO reserv = selectService.selectReservation(reservation.getReservationId());
		
		String phone = selectService.selectPhone(reserv.getMemberId());
		String name = selectService.selectName(reserv.getMemberId());
		String location_facility = selectService.selectFacility(reserv.getLocationId());
		
		Date reservationDate = reservation.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);
		
		String content = name + "님, "+ reservationDateString+ " " + reserv.getReservationStartTime() + "에 예약하신 "
    			+ location_facility + " 이용 시간이 10분 남았습니다.";
		
		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);
		
		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;
		
	}

}
