package com.hyundai.thepet.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {
	private int reservationFacilitiesTotalNum;
	private int reservationFacilitiesTotalPrice;
	private String reservationDogFacilities;
}
