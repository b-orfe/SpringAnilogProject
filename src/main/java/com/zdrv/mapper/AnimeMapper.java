package com.zdrv.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Anime;

@Mapper
public interface AnimeMapper {
	Anime selectAll();
	Anime selectById(int id);
}
