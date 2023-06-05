package com.hyundai.thepet.calender.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;
import com.hyundai.thepet.calender.vo.ReservationResultVO;

@Repository
public class CalenderDAOImpl implements CalenderDAO{
	
	Logger log = LogManager.getLogger("case3");
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CalenderVO> selectAllDetails(String category, String date) {
		String statement = "calender.calenderDetail";

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("date", date);
		
		return session.selectList(statement, map);
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
	
	@Override
	public int insertAllReservation(List<ReservationResultVO> list) {
		String statement = "calender.insertReservation";
		log.debug(list);
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			result = session.insert(statement, list.get(i));
		}
		
		return result;
	}
	
	@Override
	public int updateAllReservation(String category, List<ReservationResultVO> list) {
		String statement = "calender.updateReservation";
		int result = 0;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("category", category);
		
		
		for (int i = 0; i < list.size(); i++) {
			map.put("reservationId", Integer.toString(list.get(i).getReservationId()));
			result = session.update(statement, map);
		}
		
		
		return result;
	}
}
