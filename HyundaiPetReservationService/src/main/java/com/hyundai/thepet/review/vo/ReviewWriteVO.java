package com.hyundai.thepet.review.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewWriteVO {
	private int reservation_id;
	private float rate;
	private Date created_time;
	private String service_bt;
	private String user_contents;
	private String clean_bt;
	private String space_bt;
	private String revisit_bt;
	private String admin_contents;
	private String uuid;
	private String uploadpath;
	private String filename;
	private int review_id;
	//이것도 리뷰 id인데 mapper매칭 안되서 만든거
	private int id;
}
