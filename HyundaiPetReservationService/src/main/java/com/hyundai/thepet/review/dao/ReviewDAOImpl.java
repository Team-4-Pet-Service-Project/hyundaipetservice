package com.hyundai.thepet.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.mypage.vo.ReservVO;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	
	@Autowired
	private SqlSession session;
	
	//리뷰 확인할 수 있게 출력하게 하는 곳
	@Override
	public List<ReviewVO> reviewPrint(ReviewVO reviewVO) {
		String statement = "review.selectList";
		List<ReviewVO> vo =session.selectList(statement,reviewVO);
		return vo;
	}
	
	//리뷰 숫자 나오는 곳
	@Override
	public int reviewCount(ReviewVO reviewVO) {
		String statement = "review.cnt";
		int cnt = session.selectOne(statement,reviewVO);
		return cnt;
	}
	
	
	//리뷰작성처리하는 곳
	@Override
	public void reviewWrite(ReviewWriteVO reviewWriteVO) {
		String statement = "review.write";
		session.insert(statement,reviewWriteVO);
		String statement1 = "review.select";
		int review_id = session.selectOne(statement1, reviewWriteVO);
		reviewWriteVO.setReview_id(review_id);
		String statement2 = "review.imginsert";
		session.insert(statement2,reviewWriteVO);
	}
	
	//리뷰 상세정보 빼서 오는 곳
	@Override
	public ReviewWriteVO reviewDetail(ReviewWriteVO reviewWriteVO) {
		String statement = "review.detail";
		ReviewWriteVO vo = session.selectOne(statement, reviewWriteVO);
		return vo;
	}
	
	//이미지 정보가져오는 곳
	@Override
	public ReviewWriteVO reviewimgDetail(ReviewWriteVO reviewWriteVO) {
		String statement = "review.imgdetail";
		ReviewWriteVO vo = session.selectOne(statement, reviewWriteVO);
		return vo;
	}

	@Override
	public LocationVO selectLocation(LocationVO locationVO) {
		String statement = "review.selectlocation";
		LocationVO vo = session.selectOne(statement,locationVO);
		return vo;
	}

	
}
