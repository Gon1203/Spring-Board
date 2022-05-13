package com.myapp.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String postLogin(Login login, Model model, HttpSession session, RedirectAttributes attr) {
		// 유효성 검증
		loginService.authenticate(login);
		
		if(login.getError() == null) {
			// 로그인 성공
			User user = loginService.findUserByEmail(login.getEmail());
			session.setAttribute("user", user);
			attr.addFlashAttribute("message","로그인 성공 " + user.getName());
			return "redirect:/";
		} else {
			// 로그인 실패
			model.addAttribute("message", login.getError());
			attr.addFlashAttribute("message", "로그인 실패");
			return "login";
		}
		
		
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session, RedirectAttributes attr) {
		// 세션 삭제
		session.invalidate();
		
		attr.addFlashAttribute("message", "로그아웃 됨");
		
		return "redirect:/login";
	}
	
}
