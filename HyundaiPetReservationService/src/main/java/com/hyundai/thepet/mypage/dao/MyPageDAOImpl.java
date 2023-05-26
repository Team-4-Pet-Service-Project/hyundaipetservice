package com.hyundai.thepet.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.mypage.vo.ReservVO;

@Repository
public class MyPageDAOImpl implements MyPageDAO{
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	//예약확인 누르면 나오는 리스트 창
	@Override
	public List<ReservVO> print(ReservVO reservVO) {
		
		String statement = "page.selectList";
		List<ReservVO> vo =session.selectList(statement,reservVO);
		return vo;
	}
	
	//여기부분은 총 예약한 수를 구하기 위한 곳
	@Override
	public int count(ReservVO reservVO) {
		String statement = "page.cnt";
		int cnt = session.selectOne(statement,reservVO);
		return cnt;
	}

	@Override
	public List<ReservVO> lastprint(ReservVO reservVO) {
		String statement = "page.selectList1";
		List<ReservVO> vo =session.selectList(statement,reservVO);
		return vo;
	}

	@Override
	public int lastcount(ReservVO reservVO) {
		String statement = "page.cnt1";
		int cnt = session.selectOne(statement,reservVO);
		return cnt;
	}

	@Override
	public int reviewcheck(int reservid) {
		String statement = "page.check";
		int check = session.selectOne(statement,reservid);
		return check;
	}

}
