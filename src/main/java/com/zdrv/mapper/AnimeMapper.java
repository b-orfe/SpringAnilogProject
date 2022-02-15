package com.zdrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.Anime;

@Mapper
public interface AnimeMapper {
	List<Anime> selectAll();
	Anime selectById(int id);
}
