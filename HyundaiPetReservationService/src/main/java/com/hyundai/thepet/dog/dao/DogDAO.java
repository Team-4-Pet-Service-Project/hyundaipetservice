package com.hyundai.thepet.dog.dao;

import java.util.List;

import com.hyundai.thepet.dog.vo.DogVO;

public interface DogDAO {
	void inserDog(DogVO vo);
	List<DogVO> selectAllDogs(int loginId);
}
