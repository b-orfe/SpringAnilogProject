package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Review;

public interface ReviewService {
	
	List<Review> getAllReview();
	Review getById(int userId,int animeId);
	void insertRe(Review review);
	void deleteByIdRe(int userId,int animeId);
	void updateRe(Review review);

}
