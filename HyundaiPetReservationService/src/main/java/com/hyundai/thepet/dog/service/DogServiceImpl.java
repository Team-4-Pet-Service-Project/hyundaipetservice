package com.hyundai.thepet.dog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.dog.dao.DogDAO;
import com.hyundai.thepet.dog.vo.DogVO;

@Service
public class DogServiceImpl implements DogService{
	
	@Autowired
	private DogDAO dogDao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Override
	public int addDog(DogVO vo) {
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		int result = 0;
		try {
			result = dogDao.inserDog(vo);
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			result = 0;
		}
		
		return result;
	}
	
	@Override
	public List<DogVO> getAllDogs(int loginId) {
		return dogDao.selectAllDogs(loginId);
	}
}
