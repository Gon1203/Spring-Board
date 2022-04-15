package com.myapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.board.model.Board;

@Mapper
public interface BoardMapper {
	
	public void enroll(Board board);
	
	public List<Board> list();

	public void deleteByBno(int bno);

	public Board getBoardByBno(int bno);

	public void updateBoard(Board board);


}
