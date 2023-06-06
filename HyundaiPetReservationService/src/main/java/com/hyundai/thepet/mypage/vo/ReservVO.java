package com.hyundai.thepet.mypage.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 이건 예약확인에서 목록 리스트를 불러올 때 필요한 VO
public class ReservVO {
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
