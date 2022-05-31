# Spring-Board
 스프링 부트 게시판 프로젝트
 
 게시글 CRUD를 RESTful API 방식으로 설계하여
 
 GET, POST, PUT, DELETE method를 사용하여 처리 하고
 
 route에 resource, id를 제외한 정보를 제공하지 않음
 
 Spring Security를 통해 회원가입시 사용자 비밀번호 암호화와 페이지 인증, 인가를 처리했음
 
 댓글 기능은 AJAX 비동기 통신 방식으로 구현
  
 업데이트 중
 
## 스프링 게시판 프로젝트

- 개발 환경
  - mac os
  - Spring boot
  - Mybatis
  - Java 11 
  - Mysql
  - Lombok
  - Thymeleaf

 ## 구동화면
 
 - 회원가입
 ![무제 001](https://user-images.githubusercontent.com/89332185/169638043-34611023-90cf-40c1-a6af-3e7fca5c850d.jpeg)
 
 - 로그인
 ![무제 002](https://user-images.githubusercontent.com/89332185/169638055-922234fa-f29e-4dd2-9b1f-7adf4a8564d1.jpeg)

 - 게시판
 ![무제 003](https://user-images.githubusercontent.com/89332185/169638072-99b762f6-a4fd-4276-89b8-7060689da0cc.jpeg)
 
 - 게시물 등록
 ![무제 004](https://user-images.githubusercontent.com/89332185/169638077-b80f4b91-5b6a-4f87-9779-3cca2e0d80c4.jpeg)

 - 게시물
 ![무제 005](https://user-images.githubusercontent.com/89332185/169638083-201283fc-4e6d-45eb-8d6a-0682264173b9.jpeg)


 
---------------------

## 업데이트
<details>
  <summary>업데이트 내역 펼쳐보기!</summary>
 
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
> 생성된 개별 게시글을 게시판 목록에서 제목 클릭시 연결
> 
> 생성된 게시물에 목록, 수정, 삭제 페이지 연결
> 
> BoardController에서 페이지 get, update, delete 요청 url을 @PathVariable에서 @RequestParam으로 교체
> > ex) board/delete/{bno} => board/delete?bno={bno}

- 4월 22일
> 게시판 댓글 기능 추가(미완성) => 비동기 AJAX 방식
> 
> mapper, service, view(html) 작성
> 
> view에 AJAX js 설정 필요

- 4월 25일
> ReplyController (RestController)
>
> 댓글 ajax get, post로 작성, 리스트 받아기 완성
> 
> delete, update(put) 작성중

- 4월 26일
> 댓글 수정, 삭제 완성
>
> 회원(User) 테이블, model, mapper, controller 생성
>
> 회원가입 뷰, controller 완성 (로그인은 뷰 페이지만 생성)
> 
 
- 4월 27일
> 기본적인 로그인 뷰, 기능 완성
>
> spring security로 페이지 권한, 로그인 인증 추가(도중 오류발생) >> 수정 보완 필요
> 
 
- 4월 28일
> 27일 작업중 발생했던 오류 수정 (@어노테이션 실수), spring security 기본 사용법 미숙
> 
> Spring security 회원가입 시 user 권한 부여, 비밀번호 BCrypt 암호화 저장
>
> 커스텀 로그인 페이지로 로그인 인증
> 
 
 - 5월 13일
> side nav 추가
> 
> 로그인 성공시 Spring security Principal에 저장된 userName을 Common으로 모든 페이지에 전달
>
> 게시물 수정, 삭제 시 userName일치 여부 판단
>
> 전체적 css 수정
> 
 
 - 5월 17일
> 게시물 delete 방식을 getMapping에서 deleteMapping으로 변경
> 
> 삭제는 정상적으로 이루어 짐
>
> 삭제 후 게시물 리스트로 다시 이동하면 이동 후 에러 발생 (push X)
 
 - 5월 19일
 > 삭제 method delete , 수정 method put 으로 변경
 >
 > delete , 수정은 오류 발생
 
 - 5월 23일
 > 삭제 , 수정 오류 수정 (수정은 URI 오류)
 >
 > Delete method 전송방식을 form 제출로 변경하니 오류가 사라짐
</details>


