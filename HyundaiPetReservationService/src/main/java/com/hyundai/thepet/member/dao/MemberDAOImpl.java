package com.hyundai.thepet.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyundai.thepet.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private SqlSession session;

	@Override
	public void register(MemberVO member) throws Exception {
		String statement = "myMember.registerMember";
		int result = session.insert(statement, member);

		if (result != 1) {
			throw new Exception();
		}
	}

	@Override
	public String checkId(String email) {
		String statement = "myMember.checkId";
		String result = session.selectOne(statement, email);
		log.debug(result);
		return result;
	}

	@Override
	public String checkPhone(String phone) {
		String statement = "myMember.checkPhone";
		String result = session.selectOne(statement, phone);
		log.debug(result);
		return result;
	}

	@Override
	public MemberVO login(MemberVO member) {
		log.debug("DAO : 시작");
		String statement = "myMember.login";
		MemberVO result = session.selectOne(statement, member);
		
		log.debug("로그인 " + result);
		return result;
	}
}
