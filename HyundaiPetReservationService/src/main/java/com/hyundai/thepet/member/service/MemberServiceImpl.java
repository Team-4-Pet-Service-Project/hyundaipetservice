package com.hyundai.thepet.member.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.PasswordDecryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundai.thepet.member.dao.MemberDAO;
import com.hyundai.thepet.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private MemberDAO dao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean register(MemberVO member) {

		log.info("register service : ... " + member);
		boolean result = false;
		try {
			String inputPw = member.getPassword();
			String encodePw = passwordEncoder.encode(inputPw);
			member.setPassword(encodePw);

			dao.register(member);
			result = true;

			log.debug("service : register" + result);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public String checkId(String email) {
		log.info("dao :... " + email);
		String result = "";
		try {
			result = dao.checkId(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(result);
		return result;
	}

	@Override
	public String checkPhone(String Phone) {
		log.info("dao :... " + Phone);
		String result = "";
		try {
			result = dao.checkPhone(Phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(result);
		return result;
	}

	@Override
	public MemberVO login(MemberVO member) {
		log.debug("service : " + member);
		MemberVO result = new MemberVO();
		try {
			String inputPw = member.getPassword();
			String encodePw = passwordEncoder.encode(inputPw);
			
			log.debug("service try - encodePw" + encodePw);
			
			result = dao.login(member);
			
			log.debug("DB에서 가져온 비밀번호 " + result.getPassword());
			
			if (passwordEncoder.matches(member.getPassword(), result.getPassword())) {
				log.debug("service try - 비밀번호 성공");
				log.debug(result);
				return result;
			}else {
				log.debug("service try - 비밀번호 실패");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
