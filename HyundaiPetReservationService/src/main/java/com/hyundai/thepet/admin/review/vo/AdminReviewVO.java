package com.hyundai.thepet.admin.review.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminReviewVO {
	private int memberId; // 리뷰 작성한 사용자
	private int reservationId; // 예약 테이블 넘버
	private int reviewId; // 리뷰 테이블 넘버
	private String dogFacilities; // 구분 (케어/미용/놀이터)
	private Date reservationDate; // 이용 일자
	private int rate; // 평점 (1~5)
	private String serviceBt; // 서비스 만족도
	private String spaceBt; // 공간
	private String cleanBt; // 청결도
	private String revisitBt; // 재방문 의사
	private String adminContents; // 관리자 답변
}
