package com.hyundai.thepet.calender.dao;

import java.util.List;

import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;
import com.hyundai.thepet.calender.vo.ReservationResultVO;

public interface CalenderDAO {
	List<CalenderVO> selectAllDetails(String category, String date);
	List<CalenderVO> selectOneMonthDetails(String category, String startDate, String endDate);
	
	List<Integer> selectRemainCount(String category, String startDate, String endDate);
	
	LocationInfoVO selectLocationInfo(String branchOffice, String facilities);
	int selectPrice(String dogSize, String dogFacilities);
	int insertAllReservation(List<ReservationResultVO> list);
	int updateAllReservation(String category, List<ReservationResultVO> list);
}
