package com.hyundai.thepet.message.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.message.service.SelectService;
import com.hyundai.thepet.message.vo.ReservationVO;

import lombok.RequiredArgsConstructor;
@Controller
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledTaskController {
  private final SmsController smsController;
  private final SelectService selectService;
  
  Logger log = LogManager.getLogger("case3");

  @Scheduled(cron = "0 50 * * * *", zone= "Asia/Seoul")
  public void runEveryFiftyMinutes() throws InvalidKeyException, JsonProcessingException,  UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
   List<ReservationVO> reservations = selectService.findReservations();
   log.debug("findReservations 결과:: " + reservations);
   for (ReservationVO reserv: reservations) {
	   log.debug("reserv 하나씩 출력:: " + reserv);
	   smsController.scheduledMessage(reserv);
   }
  }

 }
