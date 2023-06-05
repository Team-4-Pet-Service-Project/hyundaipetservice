package com.hyundai.thepet.admin.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.thepet.admin.review.service.AdminReviewService;
import com.hyundai.thepet.admin.review.vo.AdminReviewVO;
import com.hyundai.thepet.admin.review.vo.UserReviewVO;

@Controller
public class AdminReviewController {
	
	@Autowired
	AdminReviewService service;
	
	
	@GetMapping(value="admin/review")
	public String reviewList(AdminReviewVO reviewVO, Model model) {
		List<AdminReviewVO> reviewNoComment = service.selectReviewNoComment();
		List<AdminReviewVO> reviewCommented = service.selectReviewCommented();
		
		System.out.println(reviewNoComment);
		
		model.addAttribute("ReviewNoComment", reviewNoComment);
		model.addAttribute("ReviewCommented", reviewCommented);
		
		int cnt = service.countNoComment();
		int cnt2 = service.countCommented();
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("cnt2", cnt2);
		
		System.out.println("cnt1: " +cnt + ", cnt2: " + cnt2);
		return "admin/reviewList";
	}
	
	
	
	@PostMapping(value="admin/review/update")
	@ResponseBody
	public void updateReview(int reviewId, String adminContents, Model model) { // 
		
		System.out.println("reviewId: " + reviewId + ", adminContents: " + adminContents);
		// 값 update
		
		UserReviewVO reviewVo = new UserReviewVO();
		reviewVo.setAdminContents(adminContents);
		reviewVo.setId(reviewId);
		int result = service.updateAdminReview(reviewVo);
		
		System.out.println("update review 실행: " + result);
		
	}
	
	@GetMapping(value="admin/review/delete")
	public void deleteReview(int reviewId, Model model) {
		System.out.println("reviewId: " + reviewId);
		
		// admin contents 삭제
		int result = service.deleteAdminReview(reviewId);
		
		System.out.println("delete review 실행" + result);
	}
	
}
