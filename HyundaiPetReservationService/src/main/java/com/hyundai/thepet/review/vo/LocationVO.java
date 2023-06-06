package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

//리뷰 수정에서 위치정보 보여줄려고 있는 것
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationVO {
	private int reservationId;
	private String address;
	private String addressDetail;
	private String dogFacilities;
	private Date reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
}
