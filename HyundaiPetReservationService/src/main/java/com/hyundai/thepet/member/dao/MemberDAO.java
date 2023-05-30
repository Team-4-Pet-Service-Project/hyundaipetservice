package com.hyundai.thepet.member.dao;

import java.util.Optional;

import com.hyundai.thepet.member.vo.MemberVO;

public interface MemberDAO {
	
	public void register(MemberVO user) throws Exception;

	public String checkId(String email);

	public MemberVO login(MemberVO member);


}
