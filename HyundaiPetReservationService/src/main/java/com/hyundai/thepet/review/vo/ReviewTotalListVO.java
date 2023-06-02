package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewTotalListVO {
	private String name;
	private int reservationId;
	private String userContents;
	private String adminContents;
	private String locationId;
	private int rate;
	private int reviewId;
	private String uuid;
	private String uploadpath;
	private String filename;
	private Date createdTime;
}
