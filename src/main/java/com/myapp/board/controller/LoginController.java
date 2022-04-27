package com.myapp.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.board.model.Login;
import com.myapp.board.model.User;
import com.myapp.board.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute Login login) {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(Login login, Model model, HttpSession session) {
		// 유효성 검증
		loginService.authenticate(login);
		
		if(login.getError() == null) {
			User user = loginService.findUserByEmail(login.getEmail());
			session.setAttribute("user", user);
			
			return "redirect:/";
		} else {
			model.addAttribute("message", login.getError());
			return "login";
		}
		
		
	}
	
}
