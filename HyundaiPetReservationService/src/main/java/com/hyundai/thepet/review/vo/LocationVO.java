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
	private int reservation_id;
	private String address;
	private String address_detail;
	private String dog_facilities;
	private Date reservation_date;
	private String reservation_start_time;
	private String reservation_end_time;
}
