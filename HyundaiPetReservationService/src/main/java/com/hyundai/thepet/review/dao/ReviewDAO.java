package com.hyundai.thepet.review.dao;

import java.util.List;

import com.hyundai.thepet.mypage.vo.ReservVO;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

public interface ReviewDAO {
	//리뷰확인 누르면 나오는 리스트 창
	public List<ReviewVO> reviewPrint(ReviewVO reviewVO);
	
	//리뷰 숫자 나오는 곳
	public int reviewCount(ReviewVO reviewVO);
	
	//리뷰 작성처리하는 곳
	public void reviewWrite(ReviewWriteVO reviewWriteVO);
	
	//리뷰상세화면에 나오는 정보 나오는 곳
	public ReviewWriteVO reviewDetail(ReviewWriteVO reviewWriteVO);

	public ReviewWriteVO reviewimgDetail(ReviewWriteVO reviewWriteVO);

	public LocationVO selectLocation(LocationVO locationVO);

	public void reviewUpdate(ReviewWriteVO reviewWriteVO);
}
