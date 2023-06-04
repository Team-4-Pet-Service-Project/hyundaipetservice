/*
 * package com.hyundai.thepet.message.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.hyundai.thepet.member.vo.MemberVO; import
 * com.hyundai.thepet.message.dao.SelectDAO; import
 * com.hyundai.thepet.message.vo.LocationVO; import
 * com.hyundai.thepet.message.vo.ReservationVO;
 * 
 * @Service public class SelectService {
 * 
 * @Autowired private SelectDAO selectDao;
 * 
 * 
 * public MemberVO selectMemberInfo(int memberId) { MemberVO result =
 * selectDao.selectMemberInfo(memberId); return result; }
 * 
 * public LocationVO selectLocationInfo(int locationId) { LocationVO result =
 * selectDao.selectLocationInfo(locationId); return result; }
 * 
 * public ReservationVO selectReservation(int reservationId) { return
 * selectDao.selectReservation(reservationId); }
 * 
 * public List<ReservationVO> findReservations() { List<ReservationVO> result =
 * selectDao.findReservations(); return result; } }
 */