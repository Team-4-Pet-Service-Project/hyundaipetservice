package com.hyundai.thepet.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.member.vo.MemberVO;
import com.hyundai.thepet.message.vo.LocationVO;
import com.hyundai.thepet.message.vo.ReservationVO;

@Repository
public class SelectDAO {
	@Autowired
	private SqlSession session;

	public MemberVO selectMemberInfo(int memberId) {
		MemberVO result = session.selectOne("forSms.selectMemberInfo", memberId);
		return result;
	}

	public LocationVO selectLocationInfo(int locationId) {
		LocationVO result = session.selectOne("forSms.selectLocationInfo", locationId);
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
