package com.foodtruck.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodtruck.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Inject
	SqlSession session;
	
	private String namespace = "com.foodtruck.mapper.MemberMapper.";
	
	public MemberDTO login(String id, String pw) {
		return null;
	}

}
