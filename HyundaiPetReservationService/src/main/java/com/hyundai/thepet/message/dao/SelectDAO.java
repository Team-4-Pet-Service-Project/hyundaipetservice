package com.hyundai.thepet.message.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.message.vo.ReservationVO;

@Repository
public class SelectDAO {
	@Autowired
	private SqlSession session;

	public String selectPhone(int memberId) {
		String result = session.selectOne("forSms.selectPhone", memberId);
		return result;
	}
	
	public String selectName(int memberId) {
		String result = session.selectOne("forSms.selectName", memberId);
		return result;
	}

	public String selectFacility(int locationId) {
		String result = session.selectOne("forSms.selectFacility", locationId);
		return result;
	}
	
	public List<ReservationVO> findReservations() {
        List<ReservationVO> result = session.selectList("forSms.findReservations");
        return result;
    }

	public ReservationVO selectReservation(int reservationId) {
		System.out.println(reservationId);
		ReservationVO result = session.selectOne("forSms.selectReservation", reservationId);
		System.out.println(result);
		return result;
	}

}
