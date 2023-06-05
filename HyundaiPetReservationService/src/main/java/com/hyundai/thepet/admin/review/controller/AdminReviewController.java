package com.hyundai.thepet.admin.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hyundai.thepet.admin.review.service.AdminReviewService;
import com.hyundai.thepet.admin.review.vo.AdminReviewVO;

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
}
