package com.myapp.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.board.model.Reply;
import com.myapp.board.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	// replyService 연결 == Autowired
	private ReplyService replyService;

	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@PostMapping
	public Reply replyEnrollPost(@RequestBody Reply reply) {
		replyService.enrollReply(reply);

		return reply;
	}

	@GetMapping("/{bno}")
	public List<Reply> replyListGet(@PathVariable int bno) {
		return replyService.replyList(bno);
	}
	
	@PutMapping
	public Reply updateReply(@RequestBody Reply reply) {
		replyService.updateReply(reply);
		return reply;
	}

}
