package com.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.board.mapper.ReplyMapper;
import com.myapp.board.model.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	private ReplyMapper replyMapper;
	
	public ReplyServiceImpl(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	@Override
	public void enrollReply(Reply reply) {
		replyMapper.enrollReply(reply);
	}

	@Override
	public List<Reply> replyList(int bno) {
		return replyMapper.replyList(bno);
	}

	@Override
	public void deleteByReplyNo(int replyNo) {
		replyMapper.deleteByReplyNo(replyNo);
	}

	@Override
	public void updateReply(Reply reply) {
		replyMapper.updateReply(reply);
	}
	

}
