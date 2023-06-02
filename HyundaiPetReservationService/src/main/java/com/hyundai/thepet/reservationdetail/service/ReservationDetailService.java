package com.hyundai.thepet.reservationdetail.service;

import com.hyundai.thepet.reservationdetail.vo.ReservationDetailVO;

public interface ReservationDetailService {
	public ReservationDetailVO infoPrint(ReservationDetailVO reservaiontDetailVO);

	public void reservationDelete(ReservationDetailVO reservationDetailVO);
}
