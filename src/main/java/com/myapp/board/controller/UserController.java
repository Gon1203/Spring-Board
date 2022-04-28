package com.myapp.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.board.mapper.UserMapper;
import com.myapp.board.model.User;

@Controller
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/register")
	public String register(@ModelAttribute User user) {

		return "register";
	}

	@PostMapping("/register")
	public String registerPost(User user, Model model, HttpSession session, RedirectAttributes attr) {
		User registedUser = userMapper.getUser(user.getEmail());

		if (registedUser != null) {
			attr.addFlashAttribute("message", "이미 가입된 이메일 입니다.");
			return "redirect:/register";
		} else {
			// 유저가 입력한 비밀번호를 암호화하여 비밀번호로 저장
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userMapper.insertUser(user);
			attr.addFlashAttribute("message", "회원가입 성공!");
			return "redirect:/login";
		}
	}
}
