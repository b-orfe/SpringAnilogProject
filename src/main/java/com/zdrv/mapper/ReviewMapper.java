package com.zdrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Review;

@Mapper
public interface ReviewMapper {
	//一覧
	List<Review> selectAll();

	//追加
	void insert(Review review);

	//削除
	void deleteById(int id);

	//更新
	void update(Review review);

}
