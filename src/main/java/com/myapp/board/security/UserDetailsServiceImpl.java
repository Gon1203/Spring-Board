package com.myapp.board.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.myapp.board.mapper.UserMapper;
import com.myapp.board.model.User;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserMapper userMapper;
	
	public UserDetailsServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userMapper.getUser(email);
		if (user != null)
			return user;
		throw new UsernameNotFoundException("유저 " + email + "이 없습니다.");
	}

}
