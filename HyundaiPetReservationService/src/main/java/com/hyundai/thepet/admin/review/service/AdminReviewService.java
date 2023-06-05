package com.hyundai.thepet.admin.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hyundai.thepet.admin.review.dao.AdminReviewDAO;
import com.hyundai.thepet.admin.review.vo.UserReviewVO;
import com.hyundai.thepet.admin.review.vo.AdminReviewVO;
import org.springframework.stereotype.Service;

@Service
public class AdminReviewService {
	@Autowired AdminReviewDAO adminReviewDAO;

	public List<AdminReviewVO> selectReviewNoComment() {
		return adminReviewDAO.selectReviewNoComment();
	}
	
	public List<AdminReviewVO> selectReviewCommented() {
		return adminReviewDAO.selectReviewCommented();
	}
	
	public int countNoComment() {
		return adminReviewDAO.countNoComment();
	}
	
	public int countCommented() {
		return adminReviewDAO.countCommented();
	}
	
	public int updateAdminReview(UserReviewVO reviewVo) {
		return adminReviewDAO.updateAdminReview(reviewVo);
	}
}
