package com.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.board.mapper.BoardMapper;
import com.myapp.board.model.Board;
import com.myapp.board.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public void enroll(Board board) {
		boardMapper.enroll(board);
	}

	@Override
	public List<Board> list() {
		
		List<Board> list = boardMapper.list();
		
		return list;
	}

	@Override
	public void deleteByBno(int bno) {
		boardMapper.deleteByBno(bno);
	}

	@Override
	public Board getBoardByBno(int bno) {
		Board board = boardMapper.getBoardByBno(bno);
		return board;
	}

	@Override
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}

	@Override
	public List<Board> pagingList(Criteria cri) {
		return boardMapper.pagingList(cri);
	}

	@Override
	public int getTotal() {
		return boardMapper.getTotal();
	}

}
