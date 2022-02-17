package com.zdrv.service;

import java.util.List;

import com.zdrv.domain.Anime;

public interface AnimeService {
	List<Anime> getAll();
	Anime getById(int id);
	Long countAnimes();
	List<Anime> limitAnimes(int offset,int num);
	
}
