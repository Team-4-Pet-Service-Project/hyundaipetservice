package com.hyundai.thepet.reservationdetail.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.reservationdetail.vo.ReservationDetailVO;

@Repository
public class ReservationDetailDAOImpl implements ReservationDetailDAO{
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	@Override
	public ReservationDetailVO infoPrint(ReservationDetailVO reservaiontDetailVO) {
		String statement = "reservationdetail.print";
		ReservationDetailVO vo = session.selectOne(statement, reservaiontDetailVO);
		return vo;
	}

	@Override
	public void reservationDelete(ReservationDetailVO reservationDetailVO) {
		String statement = "reservationdetail.delete";
		session.delete(statement, reservationDetailVO);
	}

}
