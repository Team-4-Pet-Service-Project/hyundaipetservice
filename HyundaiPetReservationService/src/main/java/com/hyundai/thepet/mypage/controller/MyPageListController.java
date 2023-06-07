package com.hyundai.thepet.mypage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hyundai.thepet.member.vo.MemberVO;
import com.hyundai.thepet.mypage.service.MyPageService;
import com.hyundai.thepet.mypage.vo.ReservVO;



@Controller
@RequestMapping(value = "mypage")
@SessionAttributes(value = { "member" })
public class MyPageListController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private MyPageService service;
	
	@ModelAttribute(value="member")
	public MemberVO setMemberVO() {
		return new MemberVO(0,"","","","","",0,"");
	}
	
	  //예약확인 누르면 나오는 리스트 창
	  
	@GetMapping(value = "reservlist")
	public String ReservList(@ModelAttribute(value = "member") MemberVO memberVO, Model model) {
		if (memberVO.getId() == 0) {
			return "redirect:/main";
		}
		List<ReservVO> vo = service.print(String.valueOf(memberVO.getId())); // 여기부분은 총 예약한 수를 구하기 위한 곳 
		int total = vo.size();
		model.addAttribute("cnt", total);
		model.addAttribute("Reserv", vo);
		return "myinfo/mypage";
	}
	
	@PostMapping(value = "getReservationList")
	@ResponseBody
	public ResponseEntity<List<ReservVO>> getAllReservationList(String loginId) {
		List<ReservVO> list = new ArrayList<>();
		list = service.print(loginId);
		return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "getPrevReservationList")
	@ResponseBody
	public ResponseEntity<List<ReservVO>> getAllPrevReservationList(String loginId) {
		List<ReservVO> list = new ArrayList<>();
		list = service.lastprint(loginId);
		return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	//리뷰작성 or 리뷰확인버튼 나오는 것(리뷰가 있는지 없는지 확인하느 로직)
	@GetMapping(value = "reviewcheck")
	@ResponseBody
	public Map<String, Object> reviewCheck(@RequestParam("reservid") int reservid){
		Map<String, Object> response = new HashMap<>();
		int check = service.reviewcheck(reservid);
		response.put("check", check);
		return response;
	}

}
