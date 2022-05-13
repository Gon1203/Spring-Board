package com.myapp.board;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myapp.board.mapper.UserMapper;
import com.myapp.board.model.User;

@ControllerAdvice
public class Common {

	@Autowired
	private UserMapper userMapper;
	
	@ModelAttribute
	public void sharedData(Model model, Principal principal) {
		// Spring Security 사용 시 Principal에 인증된 사용자 정보가 저장됨
		if(principal != null) {
			User user = userMapper.getUser(principal.getName());
			
			model.addAttribute("userName", user.getName());
		}
	}
	
}
