package com.hyundai.thepet.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.dto.ReservationLocationDTO;
import com.hyundai.thepet.admin.dto.ReservationTotalDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	SqlSession session;

	@Override
	public ReservationDTO getReservationDetail(ReservationDTO admin) {

		log.debug("DAO 접근 : " + admin);
		String statement = "myAdmin.selectReservationDetail";
		List<AdminVO> result = session.selectList(statement, admin);
		log.debug("결과 받고 나서 : " + result);

		ReservationDTO reservation = new ReservationDTO();

		int totalNum = 0;
		int totalPrice = 0;
		int totalCareNum = 0;
		int totalCarePrice = 0;
		int totalPlaygroundPrice = 0;
		int totalPlaygroundNum = 0;
		int totalBeautyNum = 0;
		int totalBeautyPrice = 0;
		/*
		 * HashMap<String, Number> map1 = new HashMap<>(); HashMap<String, Number> map2
		 * = new HashMap<>();
		 * 
		 * for (int i = 0; i < result.size(); i++) {
		 * map1.put(result.get(i).getReservationDogFacilities(),
		 * result.get(i).getReservationFacilitiesTotalPrice());
		 * map2.put(result.get(i).getReservationDogFacilities(),
		 * result.get(i).getReservationFacilitiesTotalNum()); }
		 */
		
		
		for (int i = 0; i < result.size(); i++) {
			totalNum += result.get(i).getReservationFacilitiesTotalNum();
			totalPrice += result.get(i).getReservationFacilitiesTotalPrice();
			
			if (result.get(i).getReservationDogFacilities().equals("케어")) {
				log.debug(result.get(i).getReservationFacilitiesTotalNum());
				log.debug(result.get(i).getReservationFacilitiesTotalPrice());
				
				totalCareNum = result.get(i).getReservationFacilitiesTotalNum();
				totalCarePrice = result.get(i).getReservationFacilitiesTotalPrice();
				
				log.debug("케어 : " + totalCareNum);
				log.debug("케어 : " + totalCarePrice);
				
			} else if (result.get(i).getReservationDogFacilities().equals("놀이터")) {
				log.debug("놀이터 숫자 : " + result.get(i).getReservationFacilitiesTotalNum());
				log.debug("놀이터 가격 : " + result.get(i).getReservationFacilitiesTotalPrice());

				totalPlaygroundNum = result.get(i).getReservationFacilitiesTotalNum();
				totalPlaygroundPrice = result.get(i).getReservationFacilitiesTotalPrice();
				
				log.debug("놀이터 : " + totalPlaygroundNum);
				log.debug("놀이터 : " + totalPlaygroundPrice);
				
			} else {
				log.debug(result.get(i).getReservationFacilitiesTotalNum());
				log.debug(result.get(i).getReservationFacilitiesTotalPrice());
				
				totalBeautyNum = result.get(i).getReservationFacilitiesTotalNum();
				totalBeautyPrice = result.get(i).getReservationFacilitiesTotalPrice();
				log.debug("미용 : " + totalPlaygroundNum);
				log.debug("미용 : " + totalPlaygroundPrice);

			}
		}

		reservation.setTotalNum(totalNum); 
		reservation.setTotalPrice(totalPrice);
		reservation.setTotalBeautyNum(totalBeautyNum);
		reservation.setTotalBeautyPrice(totalBeautyPrice);
		reservation.setTotalCareNum(totalCareNum);
		reservation.setTotalCarePrice(totalCarePrice);
		reservation.setTotalPlaygroundNum(totalPlaygroundNum);
		reservation.setTotalPlaygroundPrice(totalPlaygroundPrice);
		
		log.debug("price, num 세팅 " + reservation);
		return reservation;
	}

	@Override
	public ReservationTotalDTO getReservationTotal(ReservationDTO reservation) {

		String statement = "myAdmin.selectReservationTotal";
		ReservationTotalDTO result = session.selectOne(statement, reservation);
		
		return result;
	}

	@Override
	public ReservationLocationDTO postReservationLocation(ReservationLocationDTO reservation) {
		
		String statement = "myAdmin.selectReservationTotal";
		ReservationLocationDTO result = session.selectOne(statement, reservation);
		
		return result;
	}
}
