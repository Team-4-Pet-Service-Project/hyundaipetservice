package com.hyundai.thepet.dog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.dog.vo.DogVO;

@Repository
public class DogDAOImpl implements DogDAO{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void inserDog(DogVO vo) {
		String statement = "myDog.insertDog";
		session.insert(statement, vo);
	}
	
	@Override
	public List<DogVO> selectAllDogs(int loginId) {
		String statement = "myDog.selectAllDogs";
		return session.selectList(statement, loginId);
	}
}
