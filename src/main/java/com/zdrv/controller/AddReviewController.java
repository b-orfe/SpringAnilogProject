package com.zdrv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class AddReviewController {

	@GetMapping("/addReview")
	public String addReview() {
		return "addReview";
	}
}