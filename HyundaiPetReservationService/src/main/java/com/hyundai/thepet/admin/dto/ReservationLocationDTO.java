package com.hyundai.thepet.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationLocationDTO {
	private String address;
	
	private int currentMonthReservationsCount;
	private int lastMonthReservationsCount;
	
	private int currentMonthSales;
	private int currentMonthCustomerCount;
	private int currentMonthDogCount;
	
	private int lastMonthSales;
	private int lastMonthCustomerCount;
	private int lastMonthDogCount;
}
