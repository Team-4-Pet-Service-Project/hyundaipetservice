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
	private String address_detail;
	private String dog_facilities;
	private int customer_count;
	private Date reservation_date;
	private String reservation_start_time;
	private String reservation_end_time;
	private int price;
	private int dog_id;
	private int id; //로그인한 고유 id
	private int reservation_id;
	private String dog_name;
	private String review_id;
}
