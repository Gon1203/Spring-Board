package com.myapp.board.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

	private String email;
	
	private String name;
	
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 목록을 리턴
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부
		return true; // 만료되지 않음
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금 여부
		return true; // 잠금되지 않음
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		return true; // 만료되지 않음
	}

	@Override
	public boolean isEnabled() {
		// 계정 사용가능 여부
		return true; // 사용가능
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
}
