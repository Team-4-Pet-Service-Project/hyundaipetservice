package com.hyundai.thepet.reservationdetail.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetailVO {
	private int id;
	private int reservationId;
	private String email;
	private String password;
	private String name;
	private String phone;
	private Date birth;
	private Date reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
	private int customerCount;
	private int price;
	private String address;
	private String addressDetail;
	private String dogFacilities;
	private String dogName;
	private int dogAge;
	private String breed;
	private String dogSize;
	private String specialNote;
}
