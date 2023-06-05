package com.hyundai.thepet.calender.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationInfoVO {
	private int id;
	private String address;
	private String addressDetail;
	private String dogFacilities;
}
