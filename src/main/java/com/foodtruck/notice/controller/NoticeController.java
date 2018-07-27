package com.foodtruck.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.Criteria;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/noticeList.do", method = RequestMethod.GET)
	public String list(Model model, Criteria cri) {
		
		System.out.println(getClass().getSimpleName()+".NoticeList()");
		model.addAttribute("list", service.list());
		model.addAttribute("cri", cri);
		
		return "notice/List";
	}// end of list();
	
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.GET)
	public String write(Model model) {
		
		System.out.println(getClass().getSimpleName()+".NoticeWrite():GET");
		
		return "notice/Write";
	}// end of write():GET;
	
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.POST)
	public String write(NoticeDTO noticeDTO) {
		
		System.out.println(getClass().getSimpleName()+".Noticewrite():POST");
		System.out.println(noticeDTO);
		service.insert(noticeDTO);

		return "redirect:noticeList.do"; // 처리가 다 끝나면 리스트로 자동 이동시킨다.
	}// end of write():POST;
	
	@RequestMapping(value = "/noticeView.do", method = RequestMethod.GET)
	public String view(Model model, int no) {
		
		System.out.println(getClass().getSimpleName()+".NoticeView()");
		model.addAttribute("dto", service.view(no));
		
		return "notice/View";
	}// end of view();
	
	@RequestMapping(value = "/noticeUpdate.do", method = RequestMethod.GET)
	public String update(Model model, int no) {
		
		System.out.println(getClass().getSimpleName()+".NoticeUpdate():GET");
		model.addAttribute("dto", service.view(no));
		
		return "notice/update";
	}// end of update():GET;
	
	// 글수정 처리 - 수정한 제목, 내용, 작성자를 글번호와 함께 DAO에 보내서 DB에 저장한다.
	@RequestMapping(value = "/noticeUpdate.do", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) {
		
		System.out.println(getClass().getSimpleName()+".NoticeUpdate():POST");
		service.update(noticeDTO);
		
		return "redirect:view.do?no="+noticeDTO.getNo();
	}// end of update():POST;
	
	@RequestMapping(value = "/noticeList.do", method = RequestMethod.GET)
	public String delete(Model model, int no) {
		
		System.out.println(getClass().getSimpleName()+".NoticeDelete()");
		service.delete(no);
		
		return "notice/Delete";
	}// end of delete();
	
	
}
