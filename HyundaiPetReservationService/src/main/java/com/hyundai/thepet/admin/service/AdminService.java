package com.hyundai.thepet.admin.service;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.dto.ReservationLocationDTO;
import com.hyundai.thepet.admin.dto.ReservationTotalDTO;

public interface AdminService {

	public ReservationDTO getReservationDetail(ReservationDTO admin);
	public ReservationTotalDTO getReservationTotal(ReservationDTO reservation);
	public ReservationLocationDTO postReservationLocation(ReservationLocationDTO reservation);

}
