package com.myapp.board.service;

import org.springframework.stereotype.Service;

import com.myapp.board.mapper.UserMapper;
import com.myapp.board.model.Login;
import com.myapp.board.model.User;

@Service
public class LoginService {
	
	private UserMapper userMapper;
	
	public LoginService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	// 로그인 검증
	public void authenticate(Login login) {
		User user = userMapper.getUser(login.getEmail());
		
		// 로그인 시도한 이메일로 유저를 검색하여 이메일 일치 > 비밀번호 일치 여부를 판단
		// 모두 일치하면 login의 error = null
		// 불일치 하면 error 세팅
		if(user == null) {
			login.setError("존재하지 않는 이메일 입니다.");
			
		} else {
			if(!user.getPassword().equals(login.getPassword())) {
				login.setError("비밀번호가 일치하지 않습니다.");
			} else {
				login.setError(null);
			}
		}
	}
	
	// 이메일로 유저 찾기
	public User findUserByEmail(String email) {
		User user = userMapper.getUser(email);
		
		return user;
	} 

}
