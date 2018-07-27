package com.foodtruck.review.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodtruck.review.dto.Criteria;
import com.foodtruck.review.dto.ReviewDTO;
import com.foodtruck.review.service.ReviewService;

/*
 * 자동생성이 되게 하려면 
 * 1. web.xml에 설정되어 있는 xml 안에 beans > bean 태그를 이용해서 클래스 등록
 * 2. web.xml에 설정되어 있는 xml 안에 context:component-scan 을 이용해서
 *    base-package 속성의 패키지 안에서 클래스를 @Controller, @Service, @Repository,
 *    @Component, @RestController로 지정하면 자동 생성된다.
 */
@Controller
public class ReviewController {

	// 사용할 서비스 변수 선언. - DI 적용 : @Inject, @Autowired
	@Inject
	private ReviewService service;
	
	// 리스트 - DB에서 데이터를 꺼내와서 JSP로 Model객체에 데이터를 담아서 넘긴다.forward
	@RequestMapping(value = "/review/reviewlist.do", method = RequestMethod.GET)
	public String list(Model model, Criteria cri) {
//		System.out.println(getClass().getSimpleName()+".reviewlist()");
//		System.out.println(cri);
	    model.addAttribute("list", service.list(cri));
	    // jsp에서 하단부분 페이지 표시할때 cri 객체가 필요하다. model에 담아서 보낸다.
	    model.addAttribute("cri", cri);
		// prefix + return String + suffix
		// /WEB-INF/views/review/list.jsp
		return "review/reviewlist";
	}
	// 글보기 - 글번호를 전달 받아서 DB에 글번호에 맞는 reviewDTO를 가져온다. JSP로 전달
	// view.do?no=10
	@RequestMapping(value = "/review/reviewview.do", method = RequestMethod.GET)
	public String view(Model model, int rno) {
//		System.out.println(getClass().getSimpleName()+".reviewview()");
		model.addAttribute("dto", service.view(rno, true));
		// prefix + return String + suffix
		// /WEB-INF/views/review/view.jsp
		return "review/reviewview";
	}
	
	// 글쓰기 폼 -> servlet-context.xml에 view-controller tag로 지정
	@RequestMapping(value = "/review/reviewwrite.do", method = RequestMethod.GET)
	public String write() {
//		System.out.println(getClass().getSimpleName()+".reviewwrite():GET");
		// prefix + return String + suffix
		// /WEB-INF/views/review/list.jsp
		return "review/reviewwrite";
	}
	
	// 글쓰기 처리 - 사용자가 제목, 내용, 작성자 데이터 입력 후 넘긴다. -> reviewDTO
	// 리스트로 갈때에 글등록이 완료 되었다는 경고창은 띄우자(단, 한번만)
	// -> RedirectAttributes.flash속성을 이용한다.
	@RequestMapping(value = "/review/reviewwrite.do", method = RequestMethod.POST)
	public String write(ReviewDTO reviewDTO, RedirectAttributes rttr) {
//		System.out.println(getClass().getSimpleName()+".reviewwrite():POST");
		service.insert(reviewDTO);
		// 딱 한번만 적용되고 다음에는 없어지는 속성 저장
		rttr.addFlashAttribute("msg", "writeOK");
		// prefix + return String + suffix
		// /WEB-INF/views/review/list.jsp
		return "redirect:reviewlist.do"; // 처리가 다 끝나면 리스트로 자동 이동시킨다.
	}
	
	// 글수정 폼 - DB에서 글번호에 맞는 데이터를 불러와서 사용자에게 보여준다. -> JSP
	@RequestMapping(value = "/review/reviewupdate.do", method = RequestMethod.GET)
	public String update(Model model, int rno) {
//		System.out.println(getClass().getSimpleName()+".reviewupdate():GET");
		model.addAttribute("dto", service.view(rno, false));
		// prefix + return String + suffix
		// /WEB-INF/views/review/update.jsp
		return "review/reviewupdate";
	}
	
	// 글수정 처리 - 수정한 제목, 내용, 작성자를 글번호와 함께 DAO에 보내서 DB에 저장한다.
	@RequestMapping(value = "/review/reviewupdate.do", method = RequestMethod.POST)
	public String update(ReviewDTO reviewDTO, RedirectAttributes rttr) {
//		System.out.println(getClass().getSimpleName()+".reviewwrite():POST");
		service.update(reviewDTO);
		// 딱 한번만 적용되고 다음에는 없어지는 속성 저장
		rttr.addFlashAttribute("msg", "updateOK");
		// prefix + return String + suffix
		// /WEB-INF/views/review/list.jsp
		return "redirect:reviewview.do?rno="+reviewDTO.getRno();
	}
	
	// 글삭제 처리 - 삭제할 글번호를 받아서 DB에서 글번호에 맞는 데이터를 삭제한다.
	@RequestMapping(value = "/review/reviewdelete.do", method = RequestMethod.GET)
	public String delete(int rno, RedirectAttributes rttr) {
//		System.out.println(getClass().getSimpleName()+".reviewdelete()");
		service.delete(rno);
		// 딱 한번만 적용되고 다음에는 없어지는 속성 저장
		rttr.addFlashAttribute("msg", "deleteOK");
		// prefix + return String + suffix
		// /WEB-INF/views/review/list.jsp
		return "redirect:reviewlist.do";
	}
}
