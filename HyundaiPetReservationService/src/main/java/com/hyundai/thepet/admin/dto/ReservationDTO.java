package com.hyundai.thepet.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
	private String reservationDate;
	private String address;
	
	private int totalNum;
	private int totalPrice;
	
	private int totalCareNum;
	private int totalCarePrice;
	private int totalPlaygroundPrice;
	private int totalPlaygroundNum;
	private int totalBeautyNum;
	private int totalBeautyPrice;
}
