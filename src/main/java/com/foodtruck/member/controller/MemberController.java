package com.foodtruck.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodtruck.member.dto.MemberDTO;
import com.foodtruck.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService service;
	
	// 1. 로그아웃
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 세션을 지운다. -> 로그아웃
		return "redirect:/main/main.do";
	}
	
	// 2. 로그인 폼
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	
	// 3. 로그인 처리
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, String id, String pw) {
		MemberDTO memberDTO = service.login(id, pw);
		if(memberDTO == null) {
			System.out.println("아이디나 비밀번호를 확인하세요.");
			return "member/login.do";
		}
		// 아이디와 비밀번호가 맞는 경우
		session.setAttribute("login", memberDTO); // 로그인 처리 -> 세션에 값을 넣는다.
		return "redirect:/main/main.do";
	}
	
	// 4. 회원가입 폼
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "/member/join";
	}
	
	// 5. 회원가입처리
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberDTO memberdto) {
		System.out.println(getClass().getSimpleName()+".join():POST");
		System.out.println(memberdto);
		service.join(memberdto);
		
		return "redirect:/main/main.do";
	}
	
	// 6. 회원정보 보기 폼
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	public String view(HttpSession session, String id, MemberDTO memberDTO) {
		System.out.println(getClass().getSimpleName()+".view():GET");
		System.out.println(id);
		System.out.println(session.getAttribute(id));
		session.setAttribute("id", service.view(id));
		
		return "/member/view.do";
		
	}
	
	// 7. 회원정보 수정 처리
	@RequestMapping(value="/view.do", method=RequestMethod.POST)
	public String update() {
		return null;
		
	}
	
}