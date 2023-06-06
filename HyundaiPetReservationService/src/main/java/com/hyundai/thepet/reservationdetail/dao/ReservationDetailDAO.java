package com.hyundai.thepet.reservationdetail.dao;

import com.hyundai.thepet.reservationdetail.vo.ReservationDetailVO;

public interface ReservationDetailDAO {
	public ReservationDetailVO infoPrint(ReservationDetailVO reservaiontDetailVO);

	public void reservationDelete(ReservationDetailVO reservationDetailVO);
}
