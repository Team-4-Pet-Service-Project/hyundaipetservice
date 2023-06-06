package com.hyundai.thepet.dog.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hyundai.thepet.dog.service.DogService;
import com.hyundai.thepet.dog.vo.DogVO;
import com.hyundai.thepet.member.vo.MemberVO;

@Controller
public class DogController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private DogService dogService;
	
	@PostMapping(value = "addDog")
	public ResponseEntity<DogVO> addDogInfo(DogVO vo, @SessionAttribute(value = "member") MemberVO member) {
		
		vo.setMemberId(member.getId());
		int result = dogService.addDog(vo);
		return new ResponseEntity<> (vo, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "getDogs")
	public ResponseEntity<List<DogVO>> getDogsInfo(@SessionAttribute(value = "member") MemberVO member) {
		List<DogVO> list = new ArrayList<DogVO>();
		
		list = dogService.getAllDogs(member.getId());
		
		return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "deleteDog")
	@ResponseBody
	public ResponseEntity<Integer> deleteDogInfo(String dogId) {
		log.debug(dogId);
		int result = dogService.deleteDogInfo(dogId);
		
		return new ResponseEntity<> (result, HttpStatus.ACCEPTED);
	}
}
