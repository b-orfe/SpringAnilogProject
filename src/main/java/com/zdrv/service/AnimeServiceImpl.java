package com.zdrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.Anime;
import com.zdrv.mapper.AnimeMapper;

@Service
@Transactional
public class AnimeServiceImpl implements AnimeService{
	
	@Autowired
	AnimeMapper animemapper;
	
	@Override
	public Anime getById(int id) {
		
		return animemapper.selectById(id);
	}

	@Override
	public Anime getAll() {
		
		return animemapper.selectAll();
	}

}
