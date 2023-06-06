package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewWriteVO {
	private int reservationId;
	private float rate;
	private String createdTime;
	private String serviceBt;
	private String userContents;
	private String cleanBt;
	private String spaceBt;
	private String revisitBt;
	private String adminContents;
	private String uuid;
	private String uploadpath;
	private String filename;
	private int reviewId; // null
	//이것도 리뷰 id인데 mapper매칭 안되서 만든거
	private int id; // memberId, reviewId
	
	private int isAdmin; // admin인지 확인
}
