package com.hyundai.thepet.member.service;

import com.hyundai.thepet.member.vo.MemberVO;

public interface MemberService {

	public boolean register(MemberVO member);
	public boolean login(MemberVO member);
	public String checkId(String email);
	
}
