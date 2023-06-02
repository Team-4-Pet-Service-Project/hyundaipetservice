package com.hyundai.thepet.review.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hyundai.thepet.review.dao.ReviewDAO;
import com.hyundai.thepet.review.vo.LocationVO;
import com.hyundai.thepet.review.vo.ReviewTotalListVO;
import com.hyundai.thepet.review.vo.ReviewVO;
import com.hyundai.thepet.review.vo.ReviewWriteVO;

@Service
public class ReviewServiceImpl implements ReviewService{
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private ReviewDAO dao;
	
	//리뷰 확인할 수 있게 출력하게 하는 곳
	@Override
	public List<ReviewVO> reviewPrint(ReviewVO reviewVO) {
		List<ReviewVO> vo = dao.reviewPrint(reviewVO);
		return vo;
	}
	
	//리뷰 숫자 나오는 곳
	@Override
	public int reviewCount(ReviewVO reviewVO) {
		int cnt = dao.reviewCount(reviewVO);
		return cnt;
	}

	@Override
	public void reviewWrite(ReviewWriteVO reviewWriteVO) {
		//Transaction시작
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
	
			dao.reviewWrite(reviewWriteVO);
		transactionManager.commit(txStatus);
	}

	@Override
	public ReviewWriteVO reviewDetail(ReviewWriteVO reviewWriteVO) {
		ReviewWriteVO vo = dao.reviewDetail(reviewWriteVO);
		return vo;
	}
	
	@Override
	public String namePrint(ReviewWriteVO reviewWriteVO) {
		String name = dao.namePrint(reviewWriteVO);
		return name;
	}

	@Override
	public ReviewWriteVO reviewimgDetail(ReviewWriteVO reviewWriteVO) {
		ReviewWriteVO vo = dao.reviewimgDetail(reviewWriteVO);
		return vo;
	}

	@Override
	public LocationVO selectLocation(LocationVO locationVO) {
		LocationVO vo = dao.selectLocation(locationVO);
		return vo;
	}

	@Override
	public void reviewUpdate(ReviewWriteVO reviewWriteVO) {
		//Transaction시작
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		try {
			dao.reviewUpdate(reviewWriteVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void imgDelete(ReviewWriteVO reviewWriteVO) {
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		try {
			dao.imgDelete(reviewWriteVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
	}

	@Override
	public void imgUpdate(ReviewWriteVO reviewWriteVO) {
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		try {
			dao.imgUpdate(reviewWriteVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
		
	}

	@Override
	public void imgInsert(ReviewWriteVO reviewWriteVO) {
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		try {
			dao.imgInsert(reviewWriteVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
		
	}

	@Override
	public void reviewDelete(ReviewWriteVO reviewWriteVO) {
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		
		try {
			dao.reviewDelete(reviewWriteVO);
			transactionManager.commit(txStatus);
		}catch (Exception e) {
			transactionManager.rollback(txStatus);
			e.printStackTrace();
		}
	}
	
	
	//전체리스트 보여주는 곳
	@Override
	public List<ReviewTotalListVO> reviewTotalList(ReviewTotalListVO reviewTotalListVO) {
		List<ReviewTotalListVO> vo = dao.reviewTotalList(reviewTotalListVO);
		return vo;
	}

	

	
}
