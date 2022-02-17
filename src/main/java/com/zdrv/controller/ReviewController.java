package com.zdrv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdrv.domain.Anime;
import com.zdrv.domain.Review;
import com.zdrv.domain.User;
import com.zdrv.service.AnimeService;
import com.zdrv.service.ReviewService;

@Controller
@RequestMapping({"/list",""})
public class ReviewController {
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	 ReviewService rsimpl ;
	
	@Autowired
	 AnimeService aniimpl;
	
	@GetMapping
	public String list(Model model, @RequestParam(defaultValue="1") Integer page) {
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("reviews", rsimpl.allGetById(user.getId()));
		
		int numPerPage = 6;
		Long count = aniimpl.countAnimes();
		
		int totalPages = (int) Math.ceil((double) count / numPerPage);
		
		int offset = numPerPage * (page - 1);
		
		
		List<Anime> animes = aniimpl.limitAnimes(offset, numPerPage);
		System.out.println(animes);
		
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		model.addAttribute("animes", animes);
		
		
		return "list";
	}
	
	
	@GetMapping("/addReview")
	public String addReview(Model model) {
		model.addAttribute("review",new Review());
		model.addAttribute("animes",aniimpl.getAll());
		
		return "addReview";
	}
	
	@PostMapping("/addReview")
	public String addReviewPost(@Valid Review review,Errors errors,HttpSession session, Model model) {
		
		if(errors.hasErrors()) {
			model.addAttribute("animes",aniimpl.getAll());
			return "addReview";
		}
		
		User user = (User)session.getAttribute("user");
		review.setUser(user);
		rsimpl.insertRe(review);
		return "redirect:/list";
	}
	
	
	@GetMapping("/delete/{animeId}")
	public String delete(@PathVariable int animeId) {
		User user = (User)session.getAttribute("user");
		rsimpl.deleteByIdRe(user.getId(),animeId);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{animeId}")
	public String edit(@PathVariable int animeId ,Model model) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("review",rsimpl.getById(user.getId(),animeId));
		model.addAttribute("animes",aniimpl.getById(animeId));
		
		return "addReview";
	}
	
	@PostMapping("/edit/{animeId}")
	public String editPost(@Valid Review review,Errors errors) {
		if(errors.hasErrors()) {
			
			return"addReview";
		}
		
		User user = (User) session.getAttribute("user");
		review.setUser(user);
		
		rsimpl.updateRe(review);
		
		return "redirect:/list";
		
	}
	
	
}
