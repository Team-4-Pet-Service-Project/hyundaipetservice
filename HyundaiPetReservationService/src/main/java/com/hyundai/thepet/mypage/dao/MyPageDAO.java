package com.hyundai.thepet.mypage.dao;

import java.util.List;

import com.hyundai.thepet.mypage.vo.ReservVO;

public interface MyPageDAO {
	//예약확인 누르면 나오는 리스트 창
	/* public List<ReservVO> print(ReservVO reservVO); */
	public List<ReservVO> print(String loginId);
	
	//지난예약 리스트 창
	public List<ReservVO> lastprint(String loginId);
	
	//여기부분은 총 예약한 수를 구하기 위한 곳
	public int count(ReservVO reservVO);
	
	//지난예약 수
	public int lastcount(ReservVO reservVO);

	public int reviewcheck(int reservid);
}
