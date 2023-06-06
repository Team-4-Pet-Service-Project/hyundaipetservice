package com.hyundai.thepet.member.dao;

import java.util.Optional;

import com.hyundai.thepet.member.vo.MemberVO;

public interface MemberDAO {
	
	public void register(MemberVO user) throws Exception;
	public String checkId(String email);
	public String checkPhone(String phone);
	public MemberVO login(MemberVO member);


}
