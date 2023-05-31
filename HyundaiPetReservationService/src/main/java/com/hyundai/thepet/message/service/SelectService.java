package com.hyundai.thepet.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.thepet.message.dao.SelectDAO;
import com.hyundai.thepet.message.vo.ReservationVO;

@Service
public class SelectService {
	@Autowired private SelectDAO selectDao;
	

	public String selectPhone(int memberId) {
		String result = selectDao.selectPhone(memberId);
		return result;
	}


	public String selectName(int memberId) {
		String result = selectDao.selectName(memberId);
		return result;
	}

	public String selectFacility(int locationId) {
		String result = selectDao.selectFacility(locationId);
		return result;
	}
	
	public ReservationVO selectReservation(int reservationId) {
		return selectDao.selectReservation(reservationId);
	}
	
	public List<ReservationVO> findReservations() {
		List<ReservationVO> result = selectDao.findReservations();
		return result;
	}
}
