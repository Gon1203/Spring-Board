package com.myapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myapp.board.model.User;

/*
 * 매퍼 클래스
 * board와 달리 login은 mapper.xml 파일 없이 자바 매퍼에서 쿼리 처리
 * 
 * */
@Mapper
public interface UserMapper {
	
	// 유저 등록
	@Insert("insert into user values(#{email}, #{password}, #{name})")
	public int insertUser(User user);
	
	// 유저 조회
	@Select("select * from user where email = #{email}")
	public User getUser(String email);
	
	// 유저 삭제
	@Delete("delete from user where email = #{email}")
	public int deleteUser(String email);
	
	// 유저 리스트 조회
	@Select("Select * from user")
	public List<User> getUserList();
	
	// 유저 비밀번호 업데이트
	@Update("update user set (password = #{password} where email = #{email}")
	public int updateUser(User user);
	

	
	
	
}
