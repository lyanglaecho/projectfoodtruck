package com.foodtruck.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.Criteria;

public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private String local = "com.foodtruck.mapper.NoticeMapper.";

	public int getTotalCount(Criteria cri) {
		
		System.out.println(getClass().getSimpleName()+".getTotalCount()");
		
		return sqlSession.selectOne(local+"totalCount", cri);
	}// end of getTotalCount();

	public List<NoticeDTO> list(Criteria cri) {
		
		System.out.println(getClass().getSimpleName()+".list()");
		
		return sqlSession.selectList(local+"list", cri);
	}// end of list();

	public NoticeDTO view(int no) {
		
		System.out.println(getClass().getSimpleName()+".view()");
		return sqlSession.selectOne(local+"view", no);
	}// end of view()

	public void insert(NoticeDTO noticeDTO) {
		
		System.out.println(getClass().getSimpleName()+"insert()");
		sqlSession.insert(local+"insert", noticeDTO);
	}// end of insert();

	public void update(NoticeDTO noticeDTO) {
		
		System.out.println(getClass().getSimpleName()+".update()");
		
		sqlSession.update(local+"update", noticeDTO);
	}// end of update();

	public void delete(int no) {

		System.out.println(getClass().getSimpleName()+".delete()");
		
		sqlSession.delete(local+"delete", no);
	}// end of delete();

}
