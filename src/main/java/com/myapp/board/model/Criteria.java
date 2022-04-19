package com.myapp.board.model;

// paging 용도의 amount, page, skip 을 가지고 있는 클래스
public class Criteria {

	private int pageNum; // 현재 페이지

	private int amount; // 한번에 보여줄 게시글 갯수

	private int skip; // 검색시 넘어갈 게시글 갯수

	// 기본 생성자 (page와 amount 디폴트 값을 가짐)
	public Criteria() {
		this(1, 10);
		this.skip = 0;
	}

	public Criteria(int pageNum, int amount) {
		this.amount = amount;
		this.pageNum = pageNum;
		this.skip = (pageNum - 1) * amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		
		this.skip = (pageNum - 1) * amount;

	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		
		this.skip = (pageNum - 1) * amount;

	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

}
