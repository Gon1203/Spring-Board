package com.myapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.board.model.Reply;

@Mapper
public interface ReplyMapper {
	
	public void enrollReply(Reply reply);
	
	public List<Reply> replyList(int bno);

	public void deleteByReplyNo(int replyNo);

	public void updateReply(Reply reply);


}
