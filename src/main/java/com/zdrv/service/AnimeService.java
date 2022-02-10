package com.zdrv.service;

import com.zdrv.domain.Anime;

public interface AnimeService {
	Anime getAll();
	Anime getById(int id);
}
