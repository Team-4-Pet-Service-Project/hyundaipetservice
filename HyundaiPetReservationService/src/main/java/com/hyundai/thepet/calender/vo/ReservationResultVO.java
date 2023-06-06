package com.hyundai.thepet.calender.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResultVO {
	private String reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
	private int price;
	private int customerCount;
	private int memberId;
	private int dogId;
	private int locationId;
	private int reservationId;
}
