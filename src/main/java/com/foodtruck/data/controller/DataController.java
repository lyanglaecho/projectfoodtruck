package com.foodtruck.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodtruck.data.service.DataService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DataController {
	
	@Autowired
	public DataService service;
	
	@RequestMapping(value = "/data/MongodbDataPrint.do", method = RequestMethod.GET)
	public String dataPrint(Model model) {
		System.out.println(getClass().getSimpleName()+".DataPrint()");
		
		model.addAttribute("list", service.list());
		
		return "data/MongodbDataPrint";
	}// end of dataPrint()
	
	@RequestMapping(value = "/data/admin.do", method = RequestMethod.GET)
	public String admin(Model model) {
		System.out.println(getClass().getSimpleName()+".admin()");
		
		model.addAttribute("list", service.list());
		
		return "data/admin";
	}// end of admin()
	
	@RequestMapping(value = "/data/hgModel.do", method = RequestMethod.GET)
	public String hgModel(Model model) {
		System.out.println(getClass().getSimpleName()+".hgModel()");
		
		model.addAttribute("list", service.list());
		
		return "data/hgModel";
	}// end of hgModel()
	
	@RequestMapping(value = "/data/daylm.do", method = RequestMethod.GET)
	public String daylm(Model model) {
		System.out.println(getClass().getSimpleName()+".daylm()");
		
		model.addAttribute("list", service.list());
		
		return "data/daylm";
	}// end of daylm()
	
	@RequestMapping(value = "/data/timelm.do", method = RequestMethod.GET)
	public String timelm(Model model) {
		System.out.println(getClass().getSimpleName()+".admin()");
		
		model.addAttribute("list", service.list());
		
		return "data/timelm";
	}// end of timelm()
	
}
