package com.hyundai.thepet.review.service;

import java.util.List;

import com.hyundai.thepet.mypage.vo.ReservVO;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

public interface ReviewService {
	//리뷰 확인할 수 있게 출력하게 하는 곳
	public List<ReviewVO> reviewPrint(ReviewVO reviewVO);
	
	//리뷰 숫자 나오는 곳
	public int reviewCount(ReviewVO reviewVO);
	
	//리뷰 작성처리하는 곳
	public void reviewWrite(ReviewWriteVO reviewWriteVO);
	
	//리뷰 정보 가져와서 출력하는 곳
	public ReviewWriteVO reviewDetail(ReviewWriteVO reviewWriteVO);

	public ReviewWriteVO reviewimgDetail(ReviewWriteVO reviewWriteVO);

	public LocationVO selectLocation(LocationVO locationVO);
}
