package com.myapp.board.model;

public class PageMakerDTO {

	private int startPage; // 시작 페이지

	private int endPage; // 끝 페이지

	private boolean prev, next; // 이전, 다음 버튼(불린)

	private int total; // 총 게시물 수

	private Criteria cri; // pageNum, amount;

	public PageMakerDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 표시할 마지막 페이지 넘버
		// (현재 페이지 넘버 / 10.0) -> 올림 * 10 처리
		// ex) nowPageNum = 5 >> (5/10.0) == 0.5 >> Math.ceil(0.5) == 1 >> 1 * 10 == 10 
		// => endPage == 10;
		endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		// 표시 할 시작 페이지 넘버
		// ex) endpage == 20 >> startPage == 11 ( 11 ~ 20 페이지 표시) 
		startPage = endPage - 9;
		
		// 전체의 마지막 페이지
		// ex) total == 103 amount == 10
		// total * 1.0 == 103.0
		// 103.0 / 10 == 10.3 >> ceil(10.3) >> realEndPage == 11
		int realEndPage = (int)(Math.ceil(total * 1.0 / cri.getAmount()));
		
		// 실제 마지막 페이지가 표시되는 마지막 페이지 보다 작을 경우 마지막 페이지를 실제 마지막 페이지로 표시
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage > realEndPage;

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMakerDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
	

}
