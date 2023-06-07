package com.hyundai.thepet.admin.review.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hyundai.thepet.admin.review.service.AdminReviewService;
import com.hyundai.thepet.admin.review.vo.AdminReviewVO;
import com.hyundai.thepet.admin.review.vo.UserReviewVO;
import com.hyundai.thepet.member.vo.MemberVO;

@Controller
@SessionAttributes(value = { "member" })
public class AdminReviewController {
	
	@Autowired
	AdminReviewService service;
	
	Logger log = LogManager.getLogger("case3");
	
	
	@GetMapping(value="admin/review")
	@ResponseBody
	public List<AdminReviewVO> reviewList(AdminReviewVO reviewVO, Model model, @SessionAttribute(value="member") MemberVO member) {
		
		String adminAddress = member.getAdminAddress();
		int admin = member.getAdmin();
		log.debug("Session에 저장된 admin: " + admin);
		log.debug("Session에 저장된 adminAddress: " + adminAddress);
		log.debug("들어온 reviewVO: " + reviewVO);
		
		//System.out.println(reviewVO);
		//String adminAddress = "더현대 서울"; // 테스트용
		
		List<AdminReviewVO> review = service.selectReview(adminAddress);
		log.debug("selectReview 결과: "+review);
		
		return review;
	}
	
	
	
	@PostMapping(value="admin/review/update")
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
