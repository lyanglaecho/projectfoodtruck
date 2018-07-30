package com.foodtruck.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodtruck.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Inject
	private SqlSession sqlsession;
	
	private String namespace = "com.foodtruck.mapper.MemberMapper.";
	
	public MemberDTO login(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return sqlsession.selectOne(namespace+"login", map);
	}

	public void join(MemberDTO memberdto) {
		System.out.println(getClass().getSimpleName()+".join()");
		sqlsession.insert(namespace+"insert", memberdto);
	}

	public MemberDTO view(String id) {
		System.out.println(getClass().getSimpleName()+".view()");
		return sqlsession.selectOne(namespace+"view", id);
	}

	public void update(MemberDTO memberDTO) {
		System.out.println(getClass().getSimpleName()+".update()");
		sqlsession.update(namespace+"update", memberDTO);
	}
}
