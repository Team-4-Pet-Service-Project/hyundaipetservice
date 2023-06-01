package com.hyundai.thepet.calender.dao;

import java.util.List;

import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;

public interface CalenderDAO {
	List<CalenderVO> selectAllDetails(String date);
	List<CalenderVO> selectOneMonthDetails(String category, String startDate, String endDate);
	LocationInfoVO selectLocationInfo(String branchOffice, String facilities);
	int selectPrice(String dogSize, String dogFacilities);
}
