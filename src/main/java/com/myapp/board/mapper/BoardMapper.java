package com.myapp.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.board.model.Board;

@Mapper
public interface BoardMapper {
	
	public void enroll(Board board);


}
