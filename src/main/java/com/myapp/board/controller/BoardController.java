package com.myapp.board.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.board.model.Board;
import com.myapp.board.model.Criteria;
import com.myapp.board.model.PageMakerDTO;
import com.myapp.board.service.BoardService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/board")
@Log
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/enroll")
	public String boardEnrollGet(Model model) {
		
		model.addAttribute("board", new Board());
		
		return "enroll";
	}
	
//	@GetMapping("/list")
//	public String boardEnrollList(Model model) {
//		
//		List<Board> list = boardService.list();
//		
//		model.addAttribute("boards", list);
//		
//		return "list";
//	}
	
	@GetMapping("/list")
	public String boardList(Criteria cri, Model model) {
		
		model.addAttribute("boards", boardService.pagingList(cri));
		
		int total = boardService.getTotal();
		
		PageMakerDTO pmk = new PageMakerDTO(cri, total);
		
		model.addAttribute("pmk", pmk);
		
		return "list";
	}

	@PostMapping("/enroll")
	public String boardEnrollPost(Board board) {
		
		boardService.enroll(board);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{bno}")
	public String boardDelete(@PathVariable("bno") int bno) {
		
		boardService.deleteByBno(bno);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/edit/{bno}")
	public String boardEdit(@PathVariable("bno") int bno, Model model) {
		
		
		
		Board board = boardService.getBoardByBno(bno);
		
		model.addAttribute("board", board);
		
		log.info(LocalDateTime.now().toString());
		
		return "edit";
	}
	
	@PostMapping("/edit/{bno}")
	public String boardEditPost(@PathVariable("bno") int bno, Board board) {
		
		Board nowBoard = boardService.getBoardByBno(bno);
		
		

		
		nowBoard.setTitle(board.getTitle());
		nowBoard.setContent(board.getContent());
		nowBoard.setWriter(board.getWriter());
		nowBoard.setUpdateDate(LocalDateTime.now());
		
		boardService.updateBoard(nowBoard);
		
		
		return "redirect:/board/list";
	}
	

}
