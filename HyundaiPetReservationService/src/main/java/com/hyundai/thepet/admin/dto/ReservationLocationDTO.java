package com.hyundai.thepet.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationLocationDTO {
	private String address;
	
	private int todayReservation;
	private int monthReservation;
	private int lastMonthReservation;
	
	private int todaySales;
	private int monthSales;
	private int lastMonthSales;
}
