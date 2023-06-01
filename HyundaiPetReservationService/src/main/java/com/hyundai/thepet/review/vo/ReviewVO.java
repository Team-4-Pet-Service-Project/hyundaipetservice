package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {
	private String address;
	private String addressDetail;
	private String dogFacilities;
	private int customerCount;
	private Date reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
	private int price;
	private int dogId;
	private int id; //로그인한 고유 id
	private int reservationId;
	private String dogName;
	private String reviewId;
}
