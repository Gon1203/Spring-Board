package com.myapp.board.model;

import lombok.Data;

@Data
public class Login {

	private String email;
	
	private String password;
	
	private String error;
}
