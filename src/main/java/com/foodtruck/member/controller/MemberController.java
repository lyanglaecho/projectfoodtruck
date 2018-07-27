package com.foodtruck.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService service;
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 세션을 지운다. -> 로그아웃
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, String id, String pw) {
		MemberDTO dto = service.login(id, pw);
		if(dto == null) {
			System.out.println("아이디나 비밀번호를 확인하세요.");
			return "member/login.do";
		}
		// 아이디와 비밀번호가 맞는 경우
		session.setAttribute("id", dto); // 로그인 처리 -> 세션에 값을 넣는다.
		return "redirect:/main/main.do";
	}
	
	//회원가입
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "/member/join";
	}
	
}