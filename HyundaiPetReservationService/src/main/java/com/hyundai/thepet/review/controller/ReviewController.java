package com.hyundai.thepet.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.hyundai.thepet.review.vo.Criteria;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.PageMakerDTO;
import com.hyundai.thepet.review.vo.ReviewTotalListVO;
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
		String name = service.namePrint(reviewWriteVO);
		model.addAttribute("name", name);
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
		log.debug(reviewWriteVO);
		model.addAttribute("Id", reviewWriteVO.getId());
		String name = service.namePrint(reviewWriteVO);
		model.addAttribute("name", name);
		ReviewWriteVO vo = service.reviewDetail(reviewWriteVO);
		vo.setReviewId(vo.getId());
		ReviewWriteVO vo1 = service.reviewimgDetail(vo);
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
	public String reivewUpdate(ReviewWriteVO reviewWriteVO, String name, Model model) {
		// 여기서값을 가져오기
		model.addAttribute("Review", reviewWriteVO);
		model.addAttribute("name",name);
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
		service.reviewDelete(reviewWriteVO);
		// 여기선 세션으로 아이디 값을 넣어줘야 한다
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId(1);
		return "/thepet/review/list?id=" + reviewVO.getId();
	}
	
	//여긴 처음 전체 리뷰 보여주는 페이지
	@GetMapping(value = "totallist")
	public String reviewTotalList(ReviewTotalListVO reviewTotalListVO, Model model) {
		//서울 케어가 처음 선택
		// 그래서 나중에 여기로 값 보낼때 locationId 1로 줘야함
		List<ReviewTotalListVO> vo = service.reviewTotalList(reviewTotalListVO);
		model.addAttribute("Review",vo);
		log.debug(vo);
		return "review/reviewtotallist";
	}
	
	//여긴 처음 전체 리뷰 보여주는 페이지(페이징하는곳)
		@GetMapping(value = "totallist1")
		public String reviewTotalList1(ReviewTotalListVO reviewTotalListVO, Model model,Criteria cri) {
			//서울 케어가 처음 선택
			// 그래서 나중에 여기로 값 보낼때 locationId 1로 줘야함
			reviewTotalListVO.setLocationId(1);
			model.addAttribute("Review",service.reviewTotalList1(cri,reviewTotalListVO));
			int total = service.getTotal(reviewTotalListVO);
			log.debug(total);
			PageMakerDTO pageMake = new PageMakerDTO(cri, total);
			 model.addAttribute("pageMaker", pageMake);
			return "review/reviewtotallist1";
		}
	
	@GetMapping(value = "totallistajax")
	@ResponseBody
	public Map<String, Object> reviewTotalListAjax(ReviewTotalListVO reviewTotalListVO) {
		Map<String, Object> response = new HashMap<>();
		int locationId = reviewTotalListVO.getLocationId();
		//이 경우 서울 미용 or 스파 다 불러오는곳
		if(locationId==3 || locationId==43) {
			List<ReviewTotalListVO> vo = service.reviewTotalListAll(reviewTotalListVO);
			response.put("review",vo);
			response.put("cnt",vo.size());
			return response;
		}else if(locationId==6 || locationId==41) {
			List<ReviewTotalListVO> vo = service.reviewTotalListAll1(reviewTotalListVO);
			response.put("review",vo);
			response.put("cnt",vo.size());
			return response;
		}else {
			List<ReviewTotalListVO> vo = service.reviewTotalList(reviewTotalListVO);
			response.put("review",vo);
			response.put("cnt",vo.size());
			return response;
		}
		
	}
	
	//Paging하는 곳
	@GetMapping(value = "totallistajax1")
	@ResponseBody
	public Map<String, Object> reviewTotalListAjax1(ReviewTotalListVO reviewTotalListVO) {
		Map<String, Object> response = new HashMap<>();
		int locationId = reviewTotalListVO.getLocationId();
		//이 경우 서울 미용 or 스파 다 불러오는곳
		if(locationId==3 || locationId==43) {
			response.put("review",service.reviewTotalList1(new Criteria(),reviewTotalListVO));
			int total = service.getTotal(reviewTotalListVO);
			PageMakerDTO pageMake = new PageMakerDTO(new Criteria(), total);
			response.put("pageMaker", pageMake);
			response.put("location",locationId);
			return response;
		}else if(locationId==6 || locationId==41) {
			response.put("review",service.reviewTotalList1(new Criteria(),reviewTotalListVO));
			int total = service.getTotal(reviewTotalListVO);
			PageMakerDTO pageMake = new PageMakerDTO(new Criteria(), total);
			response.put("pageMaker", pageMake);
			response.put("location",locationId);
			return response;
		}else {
			response.put("review",service.reviewTotalList1(new Criteria(),reviewTotalListVO));
			int total = service.getTotal(reviewTotalListVO);
			PageMakerDTO pageMake = new PageMakerDTO(new Criteria(), total);
			response.put("pageMaker", pageMake);
			response.put("location",locationId);
			return response;
		}
		
	}

}
