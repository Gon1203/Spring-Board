package com.myapp.board.service;

import java.util.List;

import com.myapp.board.model.Board;
import com.myapp.board.model.Criteria;

public interface BoardService {

	public List<Board> list();
	
	// 게시물 등록
	public void enroll(Board board);

	// 게시물 삭제
	public void deleteByBno(int bno);

	// 게시물 개별 페이지 호출
	public Board getBoardByBno(int bno);

	// 게시물 업데이트
	public void updateBoard(Board board);
	
	// 페이징 처리 게시물 리스트
	public List<Board> pagingList(Criteria cri);
	
	// 게시물 수 가져오기
	public int getTotal();
	


}
