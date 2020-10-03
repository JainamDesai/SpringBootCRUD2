package com.SpringCRUDBySearch.SpringCRUDBySearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.SpringCRUDBySearch.SpringCRUDBySearch.factory.Helper;
import com.SpringCRUDBySearch.SpringCRUDBySearch.model.MobileStore;

@Controller
public class MobileController {
    @Autowired
	Helper help;
	@RequestMapping("/welcome")
	public String getWelcome() {
		return "Welcome";
	}
	
	@RequestMapping("/addMobile")
	public String getMobileStorePage() {
		return "Home";
	}
	
	@RequestMapping("/storeMobileData")
	public ModelAndView storeMobileData(MobileStore mobile) {
		
	    help.save(mobile);
	    ModelMap map = new ModelMap();
	    map.addAttribute("id",mobile.getId());
	    map.addAttribute("mobile_name",mobile.getMobile_name());
	    map.addAttribute("mobile_company",mobile.getMobile_company());
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("ShowSaveData");
	    mv.addObject("obj",map);
	    return mv;	
	}
	
	@RequestMapping("/showAllMobile")
	public ModelAndView getAllMobile() {
	  List<MobileStore> list = 	help.findAll();
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("ShowAllMobile");
	  mv.addObject("objs",list);
	 
	  return mv;
	}
	@RequestMapping("/deleteData")
	public String deleteData(int id) {
		
		help.deleteById(id);
		return "Delete";
	}
	@RequestMapping("/updateData")
	public ModelAndView sendUpdateData(int id)
	{
		MobileStore mobile = help.findById(id).orElse(new MobileStore());
		ModelMap map = new ModelMap();
		map.addAttribute("id",mobile.getId());
		map.addAttribute("mobile_name",mobile.getMobile_name());
		map.addAttribute("mobile_company",mobile.getMobile_company());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UpdateData");
		mv.addObject("obj",map);
		return mv;
	}
	@RequestMapping("/UpdateMobileData")
	public String updateData(MobileStore mobile)
	{
		MobileStore m = help.findById(mobile.getId()).orElse(new MobileStore());
		m.setMobile_company(mobile.getMobile_name());
		m.setMobile_company(mobile.getMobile_company());
		help.save(m);
		return "Update";
	}
	
	
	
}
