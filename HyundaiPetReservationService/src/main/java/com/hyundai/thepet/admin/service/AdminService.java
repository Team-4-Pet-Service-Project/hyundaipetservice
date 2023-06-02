package com.hyundai.thepet.admin.service;

import java.util.List;

import com.hyundai.thepet.admin.dto.ReservationDTO;
import com.hyundai.thepet.admin.vo.AdminVO;

public interface AdminService {

	public List<ReservationDTO> getReservationDetail(AdminVO admin);

}
