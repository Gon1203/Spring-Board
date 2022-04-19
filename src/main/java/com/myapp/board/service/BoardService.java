package com.myapp.board.service;

import java.util.List;

import com.myapp.board.model.Board;
import com.myapp.board.model.Criteria;

public interface BoardService {

	public List<Board> list();
	
	public void enroll(Board board);

	public void deleteByBno(int bno);

	public Board getBoardByBno(int bno);

	public void updateBoard(Board board);
	
	public List<Board> pagingList(Criteria cri);
	
	public int getTotal();

}
