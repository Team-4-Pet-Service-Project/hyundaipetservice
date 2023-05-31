package com.hyundai.thepet.dog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.thepet.dog.dao.DogDAO;
import com.hyundai.thepet.dog.vo.DogVO;

@Service
public class DogServiceImpl implements DogService{
	
	@Autowired
	private DogDAO dogDao;
	
	@Override
	public void addDog(DogVO vo) {
		dogDao.inserDog(vo);
	}
	
	@Override
	public List<DogVO> getAllDogs(int loginId) {
		return dogDao.selectAllDogs(loginId);
	}
}
