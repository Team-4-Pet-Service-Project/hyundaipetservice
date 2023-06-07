package com.hyundai.thepet.message.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.member.vo.MemberVO;
import com.hyundai.thepet.message.dto.MessageDTO;
import com.hyundai.thepet.message.dto.SmsResponseDTO;
import com.hyundai.thepet.message.service.SelectService;
import com.hyundai.thepet.message.service.SmsService;
import com.hyundai.thepet.message.vo.LocationVO;
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
		
		ReservationVO reserv = selectService.selectReservation(reservation.getId());
		MemberVO memberInfo = selectService.selectMemberInfo(reserv.getMemberId());
		LocationVO locationInfo = selectService.selectLocationInfo(reserv.getLocationId());
		
		String phone = memberInfo.getPhone();
		String name = memberInfo.getName();
		String locationFacility = locationInfo.getDogFacilities();
		String address = locationInfo.getAddress();
		String addressDetail = locationInfo.getAddressDetail();
		
		Date reservationDate = reserv.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);
		
		String content = name + "님, " + reservationDateString + " " + reserv.getReservationStartTime() + "에 "+ locationFacility + "가 예약되었습니다. \n"
				+ "위치는 " + address + " " + addressDetail + "입니다. "
				+ "예약해주셔서 감사합니다.";
		
		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);
		
		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;
		
	}


	// 예약 취소
	public SmsResponseDTO cancelMessage(ReservationVO reservation) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {

		ReservationVO reserv = selectService.selectReservation(reservation.getId());
		MemberVO memberInfo = selectService.selectMemberInfo(reserv.getMemberId());
		LocationVO locationInfo = selectService.selectLocationInfo(reserv.getLocationId());
		
		String phone = memberInfo.getPhone();
		String name = memberInfo.getName();
		String locationFacility = locationInfo.getDogFacilities();

		
		Date reservationDate = reserv.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);

		String content = name + "님, "+ reservationDateString + " " + reserv.getReservationStartTime() + "에 예약하신 "
    			+ locationFacility + " 예약이 취소되었습니다.";

		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);

		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;

	}
	
	// 예약 10분 전
	public SmsResponseDTO scheduledMessage(ReservationVO reservation) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
		ReservationVO reserv = selectService.selectReservation(reservation.getId());
		MemberVO memberInfo = selectService.selectMemberInfo(reserv.getMemberId());
		LocationVO locationInfo = selectService.selectLocationInfo(reserv.getLocationId());
		
		String phone = memberInfo.getPhone();
		String name = memberInfo.getName();
		String locationFacility = locationInfo.getDogFacilities();
		String address = locationInfo.getAddress();
		String addressDetail = locationInfo.getAddressDetail();
		
		
		Date reservationDate = reservation.getReservationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		String reservationDateString = dateFormat.format(reservationDate);
		
		String content = name + "님, " + reservationDateString + " " + reserv.getReservationStartTime() + "에 예약하신 "
				+ locationFacility + " 이용 시간이 10분 남았습니다. \n"
				+ "위치는 " + address + " " + addressDetail + "입니다. "
				+ "늦지 않게 와주시길 바랍니다.";
		
		
		MessageDTO messageDto = new MessageDTO();
		messageDto.setTo(phone);
		messageDto.setContent(content);
		
		SmsResponseDTO responseDto = smsService.sendSMS(messageDto);

		return responseDto;
		
	}

}