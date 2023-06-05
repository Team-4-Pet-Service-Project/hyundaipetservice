package com.hyundai.thepet.calender.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderVO {
	private int id;
	private String calender;
	private String startTime;
	private String endTime;
	private int remainCount;
	private String serviceType;
}
