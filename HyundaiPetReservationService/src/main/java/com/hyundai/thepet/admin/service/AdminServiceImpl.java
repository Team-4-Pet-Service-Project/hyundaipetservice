package com.hyundai.thepet.admin.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.thepet.admin.dao.AdminDAO;
import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.dto.ReservationTotalDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService{

	Logger log = LogManager.getLogger("case3");

	@Autowired
	AdminDAO dao;
	
	@Override
	public ReservationDTO getReservationDetail(ReservationDTO admin){
		
		log.debug("Service 접근 : " + admin);
		ReservationDTO result = dao.getReservationDetail(admin);
		
		return result;
	}

	@Override
	public ReservationTotalDTO getReservationTotal(ReservationDTO reservation) {
		
		log.debug("Service 접근 : " + reservation);
		ReservationTotalDTO result = dao.getReservationTotal(reservation);
		
		return result;
	}
}
