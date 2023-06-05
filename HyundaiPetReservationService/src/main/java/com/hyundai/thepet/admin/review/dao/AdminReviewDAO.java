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
	
	public List<AdminReviewVO> selectReview(String adminAddress) {
		List<AdminReviewVO> result = session.selectList("forAdminReview.selectReview", adminAddress);
		return result;
	}

	public int updateAdminReview(UserReviewVO reviewVo) {
		int result = session.update("forAdminReview.updateAdminReview", reviewVo);
		return result;
	}
	
	public int deleteAdminReview(int reviewId) {
		return session.delete("forAdminReview.deleteAdminReview", reviewId);
	}
	

	
}
