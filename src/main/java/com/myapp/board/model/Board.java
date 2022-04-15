package com.myapp.board.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Board {
	
	private int bno;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private LocalDate regDate;
	
	private LocalDate updateDate;
	
	
	

}
