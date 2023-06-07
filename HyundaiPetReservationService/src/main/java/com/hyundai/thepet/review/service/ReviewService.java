package com.hyundai.thepet.review.service;

import java.util.List;

import com.hyundai.thepet.review.vo.Criteria;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewTotalListVO;
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

	public void reviewUpdate(ReviewWriteVO reviewWriteVO);

	public void imgDelete(ReviewWriteVO reviewWriteVO);

	public void imgUpdate(ReviewWriteVO reviewWriteVO);

	public void imgInsert(ReviewWriteVO reviewWriteVO);

	public void reviewDelete(ReviewWriteVO reviewWriteVO);

	public String namePrint(ReviewWriteVO reviewWriteVO);

	public List<ReviewTotalListVO> reviewTotalList1(Criteria cri, ReviewTotalListVO reviewTotalListVO);
	
	public List<ReviewTotalListVO> reviewTotalListSeoul(Criteria cri, ReviewTotalListVO reviewTotalListVO);
	
	public List<ReviewTotalListVO> reviewTotalList1Daegu(Criteria cri, ReviewTotalListVO reviewTotalListVO);
	
	public int getTotal(ReviewTotalListVO reviewTotalListVO);

	public int getTotalSeoul(ReviewTotalListVO reviewTotalListVO);

	public int getTotalDaegu(ReviewTotalListVO reviewTotalListVO);


}
