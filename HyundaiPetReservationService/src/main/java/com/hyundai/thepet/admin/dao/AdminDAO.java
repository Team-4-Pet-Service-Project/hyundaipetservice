package com.hyundai.thepet.admin.dao;

import java.util.List;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

public interface AdminDAO {

	public List<ReservationDTO> getReservationDetail(AdminVO admin);
	
}
