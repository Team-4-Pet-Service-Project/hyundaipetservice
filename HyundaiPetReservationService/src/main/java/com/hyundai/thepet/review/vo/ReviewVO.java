package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {
	private int id;
	private Date create_time;
	private String user_contents;
	private float rate;
	private String service;
	private String space;
	private String clean;
	private String revisit;
	private String admin_contents;
	private String reservation_id;
}
