package com.hyundai.thepet.calender.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;

@Repository
public class CalenderDAOImpl implements CalenderDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CalenderVO> selectAllDetails(String date) {
		String statement = "calender.calenderDetail";
		return session.selectList(statement, date);
	}
	
	@Override
	public List<CalenderVO> selectOneMonthDetails(String category, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("category", category);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		String statement = "calender.selectOneMonth";
		return session.selectList(statement, map);
	}
	
	@Override
	public LocationInfoVO selectLocationInfo(String branchOffice, String facilities) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("branchOffice", branchOffice);
		map.put("facilities", facilities);
		
		String statement = "calender.selectLocationInfo";
		
		return session.selectOne(statement, map);
	}
	
	@Override
	public int selectPrice(String dogSize, String dogFacilities) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("dogSize", dogSize);
		map.put("dogFacilities", dogFacilities);
		String statement = "calender.selectPrice";
		
		return session.selectOne(statement, map);
	}
}
