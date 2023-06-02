package com.hyundai.thepet.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	SqlSession session;

	@Override
	public List<ReservationDTO> getReservationDetail(AdminVO admin) {
		
		log.debug("DAO 접근 : " + admin);
		String statement = "myAdmin.selectReservationDetail";
		List<AdminVO> result = session.selectList(statement, admin);
		log.debug("결과 받고 나서 : " + result);

		ArrayList<ReservationDTO> reservation = new ArrayList<>();
		
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getReservationDogFacilities() == "케어") {
				
			} else if (result.get(i).getReservationDogFacilities() == "놀이터") {
				
			} else {
				
			}
		}

		log.debug("price, num 세팅 " + result);
		return reservation;
	}
}
