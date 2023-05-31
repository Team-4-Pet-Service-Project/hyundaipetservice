package com.hyundai.thepet.calender.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.calender.vo.CalenderVO;

@Repository
public class CalenderDAOImpl implements CalenderDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CalenderVO> selectAllDetails(String date) {
		String statement = "care.calenderDetail";
		return session.selectList(statement, date);
	}
	
	@Override
	public List<CalenderVO> selectOneMonthDetails(String category, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		String statement = "care.selectOneMonth";
		return session.selectList(statement, map);
	}
}
