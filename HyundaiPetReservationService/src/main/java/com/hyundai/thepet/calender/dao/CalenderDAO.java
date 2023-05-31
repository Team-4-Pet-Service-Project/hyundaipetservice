package com.hyundai.thepet.calender.dao;

import java.util.List;

import com.hyundai.thepet.calender.vo.CalenderVO;

public interface CalenderDAO {
	List<CalenderVO> selectAllDetails(String date);
	List<CalenderVO> selectOneMonthDetails(String category, String startDate, String endDate);
}
