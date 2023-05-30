package com.hyundai.thepet.dog.service;

import java.util.List;

import com.hyundai.thepet.dog.vo.DogVO;

public interface DogService {
	void addDog(DogVO vo);
	List<DogVO> getAllDogs(int loginId);
}
