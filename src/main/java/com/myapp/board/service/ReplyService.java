package com.myapp.board.service;

import java.util.List;

import com.myapp.board.model.Reply;

public interface ReplyService {
	
public void enrollReply(Reply reply);
	
	public List<Reply> replyList(int bno);

	public void deleteByReplyNo(int replyNo);

	public void updateReply(Reply reply);
	
}
