package com.zdrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.service.AnimeService;
import com.zdrv.service.ReviewService;

@Controller
@RequestMapping({"/list",""})
public class ReviewController {
	
	@Autowired
	 private ReviewService rsimpl ;
	
	@Autowired
	private AnimeService aniimpl;
	
	@GetMapping
	public String list(Model model) {
		
		model.addAttribute("reviews",rsimpl.getAllReview());
		model.addAttribute("animes",aniimpl.getAll());
		System.out.println(aniimpl.getAll());
		return "list";
	}
	
	
}
