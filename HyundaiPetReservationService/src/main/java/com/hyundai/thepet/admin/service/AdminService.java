package com.hyundai.thepet.admin.service;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.dto.ReservationTotalDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

public interface AdminService {

	public ReservationDTO getReservationDetail(ReservationDTO admin);
	public ReservationTotalDTO getReservationTotal(ReservationDTO reservation);

}
