package com.foodtruck.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.Criteria;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO dao;

	public List<NoticeDTO> list(Criteria cri) {
		System.out.println(getClass().getSimpleName()+".list()");
		
		cri.setTotalCount(dao.getTotalCount(cri));
		cri.calcData();
		
		return dao.list(cri);
	}// end of list();

	public NoticeDTO view(int no) {
		System.out.println(getClass().getSimpleName()+".view()");
		dao.increase(no);
		return dao.view(no);
	}// end of view();

	public void insert(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+".insert()");
		dao.insert(noticeDTO);
	}// end of insert();

	public void update(NoticeDTO noticeDTO) {
		System.out.println(getClass().getSimpleName()+".update()");
		dao.update(noticeDTO);
	}// end of update();

	public void delete(int no) {
		System.out.println(getClass().getSimpleName()+".delete()");
		dao.delete(no);
	}// end of delete();

}// end of NoticeService{};
