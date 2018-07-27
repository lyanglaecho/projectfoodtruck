package com.foodtruck.fest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/fest/FestCust")
public class FestCustController {
	
	@Autowired
	private FestCustService service;
	
	
	@RequestMapping(value = "/FestCustList.do", method = RequestMethod.GET)
	public String custList(Model model) {
		
		System.out.println(getClass().getSimpleName()+".list()");
		
		model.addAttribute("list", service.list());
		
		return "fest/FestCust/FestCustList";
	}// end of custList();
	
	@RequestMapping(value = "/FestCustView.do", method = RequestMethod.GET)
	public String custView(Model model) {
		
		System.out.println(getClass().getSimpleName()+".list()");
		
		model.addAttribute("list", service.list());
		
		return "fest/FestCust/FestCustView";
	}// end of custList();
	
	@RequestMapping(value = "/FestCustList.do", method = RequestMethod.GET)
	public String custWrite(Model model) {
		
		System.out.println(getClass().getSimpleName()+".list()");
		
		model.addAttribute("list", service.list());
		
		return "fest/FestCust/FestCustWrite";
	}// end of custList();
	
	@RequestMapping(value = "/FestCustList.do", method = RequestMethod.GET)
	public String custUpdate(Model model) {
		
		System.out.println(getClass().getSimpleName()+".list()");	
		
		model.addAttribute("list", service.list());
		
		return "fest/FestCust/FestCustUpdate";
	}// end of custList();
	
//	@RequestMapping(value = "/FestCustList.do", method = RequestMethod.GET)
//	public String custDelete(Model model) {
//		
//		System.out.println(getClass().getSimpleName()+".list()");	
//		
//		model.addAttribute("list", service.list());
//		
//		return "fest/FestCust/FestCustDelete";
//	}// end of custList();
	
}
