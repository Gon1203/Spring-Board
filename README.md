# Spring-Board
 계층형 게시판 프로젝트
 
## 스프링 게시판 프로젝트

- 개발 환경
  - mac os
  - Spring boot
  - Mybatis
  - Java 11 
  - Mysql
  - Lombok
  - Thymeleaf

---------------------

## 업데이트

- 4월 14일
> 프로젝트 세팅, 생성

- 4월 15일
> Mybatis mapper.xml 활용하여 쿼리문 작성
> 
> 기본적인 게시물 생성, 리스트 받아오기(테이블), 수정, 삭제 구현 (CRUD)

- 4월 16일
> Thymeleaf fragments(nav,head) 작성

- 4월 18일
> bootstrap 연결, nav, head 파일 부트스트랩 적용
> 
> list view page 업데이트


- 4월 19일
> paging 처리하여 board list 불러오기 작성
> 
> pagination 작성 (java)
>  
> pagination view 작업중
> > startPage ~ endPage 까지 페이지 번호 불러오기 완성
> > 
> > 페이지 번호 현재 모두 1로 표시 (추가 작업 필요)
> > 
> > 이전, 이후 버튼 표시 안됨

- 4월 20일
> pagination 완성 
>
> 개별 게시글 get view 페이지 생성

- 4월 21일
> 게시물 개별 페이지 생성
> 
> 생성된 게시물에 목록, 수정, 삭제 페이지 연결
> 
> BoardController에서 페이지 get, update, delete 요청 url을 @PathVariable에서 @RequestParam으로 교체
> > ex) board/delete/{bno} => board/delete?bno={bno}

