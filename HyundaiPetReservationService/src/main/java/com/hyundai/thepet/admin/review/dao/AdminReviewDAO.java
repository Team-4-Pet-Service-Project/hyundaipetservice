package com.hyundai.thepet.admin.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.admin.review.vo.AdminReviewVO;
import com.hyundai.thepet.admin.review.vo.UserReviewVO;

@Repository
public class AdminReviewDAO {
	@Autowired private SqlSession session;
	
	public List<AdminReviewVO> selectReviewNoComment() {
		List<AdminReviewVO> result = session.selectList("forAdminReview.selectReviewNoComment");
		return result;
	}
	
	public List<AdminReviewVO> selectReviewCommented() {
		List<AdminReviewVO> result = session.selectList("forAdminReview.selectReviewCommented");
		return result;
	}
	
	public int countNoComment() {
		int result = session.selectOne("forAdminReview.countNoComment");
		return result;
	}
	
	public int countCommented() {
		int result = session.selectOne("forAdminReview.countCommented");
		return result;
	}
	
	public int updateAdminReview(UserReviewVO reviewVo) {
		int result = session.update("forAdminReview.updateAdminReview", reviewVo);
		return result;
	}
	
	
}
