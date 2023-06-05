package com.hyundai.thepet.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.thepet.mypage.service.MyPageService;
import com.hyundai.thepet.mypage.vo.ReservVO;



@Controller
@RequestMapping(value = "mypage")
public class MyPageListController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private MyPageService service;
	
	//예약확인 누르면 나오는 리스트 창
	@GetMapping(value = "reservlist")
	public String ReservList(ReservVO reservVO, Model model) {
		//여기 부분은 나중에 세션에서 값을 받아와야한다
		reservVO.setId(3);		
		List<ReservVO> vo = service.print(reservVO);
		//여기부분은 총 예약한 수를 구하기 위한 곳
		int total = service.count(reservVO);
		model.addAttribute("cnt",total);
		model.addAttribute("Reserv",vo);
		return "myinfo/mypage";
	}
	
	//예약목록과 지난목록을 누르는 ajax처리
	@GetMapping(value = "reservajax")
	@ResponseBody
    public Map<String, Object> getReservList(@RequestParam("buttonId") String buttonId,ReservVO reservVO) {
        Map<String, Object> response = new HashMap<>();
        if(buttonId.equals("buttonA")) {
        	//여기 부분은 나중에 세션에서 값을 받아와야한다
        	reservVO.setId(3);
    		List<ReservVO> vo = service.print(reservVO);
    		
    		int cnt = service.count(reservVO);
    		response.put("cnt", cnt);
            response.put("reservList", vo);
            response.put("button", buttonId);
            return response;
        }else {
        	//여기 부분은 나중에 세션에서 값을 받아와야한다
        	reservVO.setId(1);		
    		List<ReservVO> vo = service.lastprint(reservVO);
    		int cnt = service.lastcount(reservVO);
    		//여기는 리뷰작성에서 리뷰확인을 보여줄지 리뷰작성을 보여줄지
    		response.put("cnt", cnt);
            response.put("reservList", vo);
            response.put("button", buttonId);
            return response;
        }
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
