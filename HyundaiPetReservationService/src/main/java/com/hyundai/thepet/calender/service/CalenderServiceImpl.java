package com.hyundai.thepet.calender.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.calender.dao.CalenderDAO;
import com.hyundai.thepet.calender.vo.CalenderVO;
import com.hyundai.thepet.calender.vo.LocationInfoVO;
import com.hyundai.thepet.calender.vo.ReservationResultVO;

@Service
@Transactional
public class CalenderServiceImpl implements CalenderService{
	
	@Autowired
	private CalenderDAO calenderDao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Override
	public List<CalenderVO> getAllDetails(String category, String date) {
		return calenderDao.selectAllDetails(category, date);
	}
	
	@Override
	public List<CalenderVO> getOneMonthDetails(String category, String startDate, String endDate) {
		return calenderDao.selectOneMonthDetails(category, startDate, endDate);
	}
	
	@Override
	public List<Integer> getAllRemainCount(String category, String startDate, String endDate) {
		return calenderDao.selectRemainCount(category, startDate, endDate);
	}
	
	@Override
	public LocationInfoVO getLocationInfo(String branchOffice, String facilities) {
		return calenderDao.selectLocationInfo(branchOffice, facilities);
	}
	
	@Override
	public int getPrice(String dogSize, String dogFacilities) {
		return calenderDao.selectPrice(dogSize, dogFacilities);
	}
	
	@Override
	public List<ReservationResultVO> setAllReservation(String category, List<ReservationResultVO> list) {
		
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {
			calenderDao.insertAllReservation(list);
			calenderDao.updateAllReservation(category, list); // result = 있던거 뺌
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
		}
		
//		calenderDao.insertAllReservation(list);
		
		return list;
	}
}
