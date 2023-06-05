package com.hyundai.thepet.calender.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationListVO {
	private String category;
	private List<ReservationResultVO> reservationList;
}
