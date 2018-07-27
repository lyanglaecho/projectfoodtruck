package com.foodtruck.review.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.foodtruck.review.dto.Criteria;
import com.foodtruck.review.dto.ReviewDTO;

@Repository
public class ReviewDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 게시판 리스트
	public List<ReviewDTO> list(Criteria cri) {
//		System.out.println(getClass().getSimpleName()+".list()");
		return sqlSession.selectList
				("com.foodtruck.mapper.reviewmapper.list", cri);
	}

	// 게시판 글보기, 글 수정 폼 - 글번호가 필요하다. 파라메터로 전달 받는다.
	public ReviewDTO view(Integer rno) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".view()");
		return sqlSession.selectOne
		("com.foodtruck.mapper.reviewmapper.view", rno);
	}
	
	// 게시판 글쓰기 
	public void insert(ReviewDTO ReviewDTO) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".insert()");
		sqlSession.insert
		("com.foodtruck.mapper.reviewmapper.insert", ReviewDTO);
	}
	
	// 게시판 글수정 처리
	public void update(ReviewDTO ReviewDTO) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".update()");
		sqlSession.update
		("com.foodtruck.mapper.reviewmapper.update", ReviewDTO);
	}
	
	// 게시판 글보기 1 증가 처리
	public void increase(Integer rno) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".increase()");
		sqlSession.update
		("com.foodtruck.mapper.reviewmapper.increase", rno);
	}
	
	// 게시판 글삭제 - 글번호를 받아서 처리
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".delete()");
		sqlSession.delete
		("com.foodtruck.mapper.reviewmapper.delete", rno);
	}

	// 게시판 전체 글의 갯수 구하는 메서드
	public Integer getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
//		System.out.println(getClass().getSimpleName()+".getTotalCount()");
		return sqlSession.selectOne
		("com.foodtruck.mapper.reviewmapper.totalCount", cri);
	}
	
}
