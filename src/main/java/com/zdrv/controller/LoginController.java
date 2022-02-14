package com.zdrv.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zdrv.domain.User;
import com.zdrv.service.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UserServiceImpl userservice;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(HttpSession session, @Valid User user,Errors errors) {
		if(errors.hasErrors()) {
			return "login";
		}
		
		User loginUser = userservice.getLoginUser(user);
		
		if(loginUser==null) {
			errors.rejectValue("loginId", "error.login","ログインIDまたはパスワードが違います");
			return "login";
		}
		
		session.setAttribute("user", loginUser);
		return "redirect:/list";
		
	}
}
