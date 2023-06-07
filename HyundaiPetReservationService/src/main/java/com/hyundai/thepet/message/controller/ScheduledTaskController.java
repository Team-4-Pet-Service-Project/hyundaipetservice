package com.hyundai.thepet.message.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyundai.thepet.message.controller.SmsController;
import com.hyundai.thepet.message.service.SelectService;
import com.hyundai.thepet.message.vo.ReservationVO;

import lombok.RequiredArgsConstructor;
@Controller
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledTaskController {
  private final SmsController smsController;
  private final SelectService selectService;

  @Scheduled(cron = "0 1 * * * *", zone= "Asia/Seoul")
  public void runEveryFiftyMinutes() throws InvalidKeyException, JsonProcessingException,  UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
   List<ReservationVO> reservations = selectService.findReservations();
   for (ReservationVO reserv: reservations) {
    smsController.scheduledMessage(reserv);
   }
  }

 }