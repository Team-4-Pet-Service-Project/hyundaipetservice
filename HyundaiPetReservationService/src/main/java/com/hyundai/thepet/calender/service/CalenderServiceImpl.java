package com.hyundai.thepet.calender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.thepet.calender.dao.CalenderDAO;
import com.hyundai.thepet.calender.vo.CalenderVO;

@Service
public class CalenderServiceImpl implements CalenderService{
	
	@Autowired
	private CalenderDAO calenderDao;
	
	@Override
	public List<CalenderVO> getAllDetails(String date) {
		return calenderDao.selectAllDetails(date);
	}
	
	@Override
	public List<CalenderVO> getOneMonthDetails(String category, String startDate, String endDate) {
		return calenderDao.selectOneMonthDetails(category, startDate, endDate);
	}
}
