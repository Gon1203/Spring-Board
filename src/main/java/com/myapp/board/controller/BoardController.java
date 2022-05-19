package com.myapp.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.board.model.Board;
import com.myapp.board.model.Criteria;
import com.myapp.board.model.PageMakerDTO;
import com.myapp.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	// boardService 연결
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	// 게시물 목록 가져오기(페이징 처리)
	@GetMapping("list")
	public String boardList(Criteria cri, Model model) {
		
		model.addAttribute("boards", boardService.pagingList(cri));
		
		int total = boardService.getTotal();
		
		PageMakerDTO pmk = new PageMakerDTO(cri, total);
		
		model.addAttribute("pmk", pmk);
		
		return "list";
	}
	
	@GetMapping("{bno}")
	public String getBoard(@PathVariable("bno") int bno, Model model) {
		
		model.addAttribute("board", boardService.getBoardByBno(bno));
		
		return "get";
	}
	
	// 게시물 등록 뷰 호출
	@GetMapping("enroll")
	public String boardEnrollGet(Model model) {
		
		model.addAttribute("board", new Board());
		
		return "enroll";
	}

	// 게시물 등록 post
	@PostMapping("enroll")
	public String boardEnrollPost(Board board) {
		
		boardService.enroll(board);
		
		return "redirect:/board/list";
	}
	
	// 게시물 삭제(bno)
	@DeleteMapping("{bno}")
	public void boardDelete (@PathVariable("bno") int bno) throws Exception {
	
		boardService.deleteByBno(bno);
		
//		return "redirect:/";
		
	}
	
	// 게시물 수정 get
	@GetMapping("/enroll/{bno}")
	public String boardEdit(@PathVariable("bno") int bno, Model model) {
		
		
		Board board = boardService.getBoardByBno(bno);
		
		model.addAttribute("board", board);
		
		return "edit";
	}
	
	// 게시물 수정 put
	@PutMapping("/edit/{bno}")
	public String boardEditPost(@PathVariable("bno") int bno , Board board) {
		
		boardService.updateBoard(board);
		
		return "redirect:/board/list";
	}
	

}
