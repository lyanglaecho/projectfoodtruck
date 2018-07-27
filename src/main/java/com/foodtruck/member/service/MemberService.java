package com.foodtruck.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodtruck.member.dao.MemberDAO;
import com.foodtruck.member.dto.MemberDTO;

@Service
public class MemberService {

	@Inject 
	MemberDAO dao;
	
	public MemberDTO login(String id, String pw) {
		return dao.login(id, pw);
	}

}