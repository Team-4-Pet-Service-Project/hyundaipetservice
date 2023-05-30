package com.hyundai.thepet.member.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.member.dao.MemberDAO;
import com.hyundai.thepet.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private PlatformTransactionManager transactionManger;
	@Autowired
	private MemberDAO dao;

	@Override
	public boolean register(MemberVO member) {

		TransactionStatus txStatus = transactionManger.getTransaction(new DefaultTransactionDefinition());

		log.info("register service : ... " + member);
		
		boolean result = false;
		try {
			dao.register(member);
			result = true;
			log.debug("service : register" + result);
			transactionManger.commit(txStatus);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			transactionManger.rollback(txStatus);
		}
		return result;
	}

	@Override
	public String checkId(String email) {
		log.info("dao :... " + email);
		String result = "";
		try {
			result = dao.checkId(email);
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(result);
		return result;
	}

	@Override
	public MemberVO login(MemberVO member) {

		MemberVO result = new MemberVO();
		try {
			result = dao.login(member);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
