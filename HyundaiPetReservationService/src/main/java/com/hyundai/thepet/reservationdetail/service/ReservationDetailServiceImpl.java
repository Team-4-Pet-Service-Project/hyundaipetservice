package com.hyundai.thepet.reservationdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.reservationdetail.dao.ReservationDetailDAO;
import com.hyundai.thepet.reservationdetail.vo.ReservationDetailVO;

@Service
public class ReservationDetailServiceImpl implements ReservationDetailService{
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	ReservationDetailDAO dao;
	
	@Override
	public ReservationDetailVO infoPrint(ReservationDetailVO reservaiontDetailVO) {
		ReservationDetailVO vo = dao.infoPrint(reservaiontDetailVO);
		return vo;
	}

	@Override
	public void reservationDelete(ReservationDetailVO reservationDetailVO) {
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		try {
			dao.reservationDelete(reservationDetailVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
	}

}
