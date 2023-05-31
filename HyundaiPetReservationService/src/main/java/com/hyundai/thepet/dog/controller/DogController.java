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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hyundai.thepet.dog.service.DogService;
import com.hyundai.thepet.dog.vo.DogVO;

@Controller
public class DogController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private DogService dogService;
	
	@PostMapping(value = "addDog")
	public ResponseEntity<DogVO> addDogInfo(DogVO vo, @SessionAttribute(value = "loginId") int loginId) {
		log.debug(loginId);
		
		vo.setMemberId(loginId);
		log.debug(vo);
		int result = dogService.addDog(vo);
		log.debug(result);
		return new ResponseEntity<> (vo, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "getDogs")
	public ResponseEntity<List<DogVO>> getDogsInfo(@SessionAttribute(value = "loginId") int loginId) {
		List<DogVO> list = new ArrayList<DogVO>();
		
		list = dogService.getAllDogs(loginId);
		
		return new ResponseEntity<> (list, HttpStatus.ACCEPTED);
	}
}
