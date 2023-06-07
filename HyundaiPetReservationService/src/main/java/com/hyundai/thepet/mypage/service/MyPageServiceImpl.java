package com.hyundai.thepet.mypage.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.mypage.dao.MyPageDAO;
import com.hyundai.thepet.mypage.vo.ReservVO;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private MyPageDAO dao;
	
	//예약확인 누르면 나오는 리스트 창
	@Override
	public List<ReservVO> print(String loginId) {
		List<ReservVO> vo = dao.print(loginId);
		return vo;
	}

	@Override
	public int count(ReservVO reservVO) {
		int cnt = dao.count(reservVO);
		return cnt;
	}
	
	//지난예약부분
	@Override
	public List<ReservVO> lastprint(String loginId) {
		List<ReservVO> vo = dao.lastprint(loginId); 
		return vo;
	}

	@Override
	public int lastcount(ReservVO reservVO) {
		int cnt = dao.lastcount(reservVO);
		return cnt;
	}

	@Override
	public int reviewcheck(int reservid) {
		int check = dao.reviewcheck(reservid);
		return check;
	}

	
}
