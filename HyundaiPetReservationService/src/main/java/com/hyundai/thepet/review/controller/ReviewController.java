package com.hyundai.thepet.review.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.thepet.mypage.vo.ReservVO;
import com.hyundai.thepet.review.service.ReviewService;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

@Controller

@RequestMapping(value = "review")
public class ReviewController {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	ReviewService service;

	// 리뷰작성하는곳

	@GetMapping(value = "write")
	public String ReviewWrite(ReservVO reservVO, Model model) {
		model.addAttribute("Reserv", reservVO);
		return "review/reviewwrite";
	}

	// 리뷰작성 후 다시 리뷰확인 리스트로 가는 곳

	@PostMapping(value = "writecheck")
	public String ReviewWriteCheck(ReviewWriteVO reviewWriteVO) {
		service.reviewWrite(reviewWriteVO);
		ReviewVO reviewVO = new ReviewVO();
		// 여기선세션으로 아이디 값을 넣어줘야 한다
		reviewVO.setId(1);
		return "redirect:/review/list?id=" + reviewVO.getId();
	}

	// (사이드바 누르면)리뷰확인리스트 보여주는 곳

	@GetMapping(value = "list")
	public String ReviewList(ReviewVO reviewVO, Model model) {
		List<ReviewVO> vo = service.reviewPrint(reviewVO);
		int cnt = service.reviewCount(reviewVO);
		model.addAttribute("Review", vo);
		model.addAttribute("cnt", cnt);
		return "review/reviewlist";
	}

	// 리뷰상세확인하는곳1 (지난예약 버튼에서 상세화면으로가는 경우)

	@GetMapping(value = "detail1")
	public String ReviewDetail1(ReviewWriteVO reviewWriteVO, Model model) {
		model.addAttribute("Id", reviewWriteVO.getId());
		ReviewWriteVO vo = service.reviewDetail(reviewWriteVO);
		vo.setReviewId(vo.getId());
		ReviewWriteVO vo1 = service.reviewimgDetail(vo);
		model.addAttribute("Review", vo);
		// 여기에 review_id, filename, uploadpath, uuid
		model.addAttribute("Review1", vo1);

		if (vo1 == null) {

		} else {
			String path = vo1.getUploadpath();
			path += "\\";
			path += vo1.getFilename();
			path = path.replace("\\", "/");
			model.addAttribute("path", path);
		}
		return "review/reviewdetail";
	}

	// 위와 아래로 나눈 이유는 위에가 review_id를 가지고 올수 가 없다 //사이드바에서 리뷰확인누른다음 리뷰상세 들어가는 곳

	@GetMapping(value = "datail2")
	public String ReviewDetail2(ReviewWriteVO reviewWriteVO, Model model) {
		model.addAttribute("Id", reviewWriteVO.getId());
		ReviewWriteVO vo = service.reviewDetail(reviewWriteVO);
		vo.setReviewId(vo.getId());
		ReviewWriteVO vo1 = service.reviewimgDetail(vo);
		log.debug(vo);
		log.debug(vo1);
		model.addAttribute("Review", vo);
		// 여기에review_id, filename, uploadpath, uuid
		model.addAttribute("Review1", vo1);
		if (vo1 == null) {

		} else {
			String path = vo1.getUploadpath();
			path += "\\";
			path += vo1.getFilename();
			path = path.replace("\\", "/");
			model.addAttribute("path", path);
		}
		return "review/reviewdetail";
	}

	// 리뷰업데이트창 넘어가는 컨트롤러

	@GetMapping(value = "update")
	public String reivewUpdate(ReviewWriteVO reviewWriteVO, Model model) {
		// 여기서값을 가져오기
		model.addAttribute("Review", reviewWriteVO);
		// 여기서 이용시설이랑 이용일자 데이터베이스처리
		LocationVO locationVO = new LocationVO();
		locationVO.setReservationId(reviewWriteVO.getReservationId());
		locationVO = service.selectLocation(locationVO);
		model.addAttribute("Location", locationVO);
		return "review/reviewupdate";
	}

	// 리뷰 업데이트 처리하는 컨트롤러

	@PostMapping(value = "updatecom")
	public String reviewComplete(ReviewWriteVO reviewWriteVO) {
		// 여기서 리뷰 업데이트하는 곳
		service.reviewUpdate(reviewWriteVO);
		// null인경우 이미지가 있었는데 삭제된 경우
		// uuid=""인 경우원래 이미지가 없는 경우
		// else는 이미지 업데이트한번 해주는 로직
		if (reviewWriteVO.getUuid() == "") {
		} else if (reviewWriteVO.getUuid() == null) {
			service.imgDelete(reviewWriteVO);
		} else {
			//여기서 review_imgs테이블이 있는지 없는지 확인하고
			ReviewWriteVO vo = service.reviewimgDetail(reviewWriteVO);
			if(reviewWriteVO.getUuid().startsWith(",")) {
				reviewWriteVO.setUuid(reviewWriteVO.getUuid().substring(1));
				reviewWriteVO.setUploadpath(reviewWriteVO.getUploadpath().substring(1));
			}
			if(vo==null) {
				//insert
				service.imgInsert(reviewWriteVO);
			}else {
				service.imgUpdate(reviewWriteVO);
			}
			
		}
		ReviewVO reviewVO = new ReviewVO(); // 여기선 세션으로 아이디 값을 넣어줘야 한다
		reviewVO.setId(1);
		return "redirect:/review/list?id=" + reviewVO.getId();
	}
	
	@GetMapping(value = "delete")
	@ResponseBody
	public String reviewDelete(ReviewWriteVO reviewWriteVO) {
		log.debug(reviewWriteVO.getReviewId());
		service.reviewDelete(reviewWriteVO);
		// 여기선 세션으로 아이디 값을 넣어줘야 한다
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId(1);
		return "/thepet/review/list?id=" + reviewVO.getId();
	}

}
