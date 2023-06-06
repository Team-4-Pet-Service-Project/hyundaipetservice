package com.hyundai.thepet.calender.service;

import java.util.List;

import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;
import com.hyundai.thepet.calender.vo.ReservationResultVO;

public interface CalenderService {
	List<CalenderVO> getAllDetails(String category, String date);
	List<CalenderVO> getOneMonthDetails(String category, String startDate, String endDate);
	LocationInfoVO getLocationInfo(String branchOffice, String facilities);
	int getPrice(String dogSize, String dogFacilities);
	List<ReservationResultVO> setAllReservation(String category, List<ReservationResultVO> list);
}
