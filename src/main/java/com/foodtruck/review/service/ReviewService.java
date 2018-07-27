package com.foodtruck.review.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodtruck.review.dao.ReviewDAO;
import com.foodtruck.review.dto.Criteria;
import com.foodtruck.review.dto.ReviewDTO;

@Service
public class ReviewService {

	@Inject
	private ReviewDAO dao;
	
	// 게시판 리스트
	public List<ReviewDTO> list(Criteria cri) {
		System.out.println(getClass().getSimpleName()+".list()");
		// 페이지에 대한 계산을 한다.
		System.out.println("일단 서비스들어왔고에서왔고");
		System.out.println(cri);
		System.out.println(cri);
		cri.setTotalCount(dao.getTotalCount(cri));
		System.out.println(cri);
		System.out.println(cri);
		System.out.println(cri);
		System.out.println(cri);
		System.out.println(cri);
		cri.calcData();
		System.out.println(cri);
		return dao.list(cri);
	}
	
	// 게시판 글보기+1증가, 글수정 - 글번호를 받아서 dao 한테 전달
	public ReviewDTO view(Integer rno, boolean isView) {
		System.out.println(getClass().getSimpleName()+".view()");
		// 글보기 할 때 increase 시킨다. 조회수 1증가.
		if(isView) dao.increase(rno);
		return dao.view(rno);
	}
	
	// 게시판 글쓰기 - ReviewDTO를 받아서 dao 한테 전달
	public void insert(ReviewDTO ReviewDTO) {
		System.out.println(getClass().getSimpleName()+".insert()");
		System.out.println("서비스 인설트에 들어왔고");
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		dao.insert(ReviewDTO);
	}
	
	// 게시판 글수정 - ReviewDTO를 받아서 dao 한테 전달
	public void update(ReviewDTO ReviewDTO) {
		System.out.println(getClass().getSimpleName()+".update()");
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		System.out.println(ReviewDTO);
		dao.update(ReviewDTO);
	}
	
	// 게시판 글삭제 - 글번호(no)를 받아서 dao 한테 전달
	public void delete(Integer rno) {
		System.out.println(getClass().getSimpleName()+".delete()");
		dao.delete(rno);
	}
	
	
}
