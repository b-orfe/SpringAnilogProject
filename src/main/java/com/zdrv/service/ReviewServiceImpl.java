package com.zdrv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.Review;
import com.zdrv.mapper.ReviewMapper;

@Service
@Transactional

public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewMapper reviewmapper;
	
	@Override
	public List<Review> getAllReview() {
		
		return reviewmapper.selectAll();
	}

	@Override
	public void insertRe(Review review) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteByIdRe(int id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void updateRe(Review review) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
