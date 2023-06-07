package com.hyundai.thepet.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.review.vo.Criteria;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewListWrapper;
import com.hyundai.thepet.review.vo.ReviewTotalListVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	
	Logger log = LogManager.getLogger("case3");
	
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
		reviewWriteVO.setReviewId(review_id);
		if(reviewWriteVO.getUuid()==null) {
			return;
		}else {
			String statement2 = "review.imginsert";
			session.insert(statement2,reviewWriteVO);
		}
		
	}
	
	// 리뷰 이름 오는것
	@Override
	public String namePrint(ReviewWriteVO reviewWriteVO) {
		String statement = "review.nameprint";
		String name = session.selectOne(statement,reviewWriteVO);
		return name;
	}
	
	//리뷰 상세정보 빼서 오는 곳
	@Override
	public ReviewWriteVO reviewDetail(ReviewWriteVO reviewWriteVO) {
		String statement = "review.detail";
		ReviewWriteVO vo = session.selectOne(statement, reviewWriteVO);
		log.debug("reviewWrite : 결과값" + vo);
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

	@Override
	public void reviewUpdate(ReviewWriteVO reviewWriteVO) {
		String statement = "review.update";
		session.update(statement, reviewWriteVO);
	}

	@Override
	public void imgDelete(ReviewWriteVO reviewWriteVO) {
		String statement = "review.imgdelete";
		session.delete(statement, reviewWriteVO);
	}

	@Override
	public void imgUpdate(ReviewWriteVO reviewWriteVO) {
		String statement = "review.imgupdate";
		session.update(statement, reviewWriteVO);
	}

	//리뷰 이미지 넣는 곳
	@Override
	public void imgInsert(ReviewWriteVO reviewWriteVO) {
		String statement = "review.imginsert";
		session.insert(statement, reviewWriteVO);
	}
	
	//리뷰 삭제하는 곳
	@Override
	public void reviewDelete(ReviewWriteVO reviewWriteVO) {
		String statement = "review.delete";
		session.delete(statement, reviewWriteVO);
	}
	
	
	//페이징
	@Override
	public List<ReviewTotalListVO> reviewTotalList1(@Param("criteria") Criteria cri, @Param("reviewTotalListVO") ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.reviewTotalList1";
		ReviewListWrapper wrapper = new ReviewListWrapper(cri,reviewTotalListVO);
		List<ReviewTotalListVO> vo =  session.selectList(statement,wrapper);
		log.debug(vo);
		return vo;
	}
	
	@Override
	public List<ReviewTotalListVO> reviewTotalListSeoul(Criteria cri, ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.reviewTotalListSeoul";
		ReviewListWrapper wrapper = new ReviewListWrapper(cri,reviewTotalListVO);
		List<ReviewTotalListVO> vo =  session.selectList(statement,wrapper);
		log.debug(vo);
		return vo;
	}

	@Override
	public List<ReviewTotalListVO> reviewTotalList1Daegu(Criteria cri, ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.reviewTotalListDaegu";
		ReviewListWrapper wrapper = new ReviewListWrapper(cri,reviewTotalListVO);
		List<ReviewTotalListVO> vo =  session.selectList(statement,wrapper);
		log.debug(vo);
		return vo;
	}

	@Override
	public int getTotal(ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.total";
		int cnt = session.selectOne(statement,reviewTotalListVO);
		return cnt;
	}

	@Override
	public int getTotalSeoul(ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.totalSeoul";
		int cnt = session.selectOne(statement,reviewTotalListVO);
		return cnt;
	}

	@Override
	public int getTotalDaegu(ReviewTotalListVO reviewTotalListVO) {
		String statement = "review.totalDaegu";
		int cnt = session.selectOne(statement,reviewTotalListVO);
		return cnt;
	}
	
	//리뷰 전체리스트 출력하는 곳
		@Override
		public List<ReviewTotalListVO> reviewTotalList(ReviewTotalListVO reviewTotalListVO) {
			String statement = "review.totallist";
			List<ReviewTotalListVO> vo =  session.selectList(statement, reviewTotalListVO);
			return vo;
		}
		
		//서울(미용, 스파)
		@Override
		public List<ReviewTotalListVO> reviewTotalListAll(ReviewTotalListVO reviewTotalListVO) {
			String statement = "review.totallistAll";
			List<ReviewTotalListVO> vo =  session.selectList(statement, reviewTotalListVO);
			return vo;
		}
		
		//대구(미용, 스파)
		@Override
		public List<ReviewTotalListVO> reviewTotalListAll1(ReviewTotalListVO reviewTotalListVO) {
			String statement = "review.totallistAll1";
			List<ReviewTotalListVO> vo =  session.selectList(statement, reviewTotalListVO);
			return vo;
		}
	
}
