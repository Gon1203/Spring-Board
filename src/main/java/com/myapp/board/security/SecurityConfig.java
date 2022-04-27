package com.myapp.board.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.antMatchers("/board/enroll").authenticated()
				.antMatchers("/board/delete").authenticated()
				.antMatchers("/board/edit").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login");
	}
}
