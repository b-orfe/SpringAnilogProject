package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Review;

public interface ReviewService {
	
	List<Review> getAllReview();
	void insertRe(Review review);
	void deleteByIdRe(int id);
	void updateRe(Review review);

}
