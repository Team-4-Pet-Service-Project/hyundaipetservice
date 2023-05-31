package com.hyundai.thepet.calender.service;

import java.util.List;

import com.hyundai.thepet.calender.vo.CalenderVO;

public interface CalenderService {
	List<CalenderVO> getAllDetails(String date);
	List<CalenderVO> getOneMonthDetails(String category, String startDate, String endDate);
}
