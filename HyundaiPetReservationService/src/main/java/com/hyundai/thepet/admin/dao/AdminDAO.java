package com.hyundai.thepet.admin.dao;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.dto.ReservationLocationDTO;
import com.hyundai.thepet.admin.dto.ReservationTotalDTO;

public interface AdminDAO {

	public ReservationDTO getReservationDetail(ReservationDTO admin);

	public ReservationTotalDTO getReservationTotal(ReservationDTO reservation);
	public ReservationLocationDTO postReservationLocation(ReservationLocationDTO reservation);
	
}
