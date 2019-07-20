package com.tjetc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.CusLinkman;

import com.tjetc.service.impl.LinkManService;


@Controller
@RequestMapping("/linkman")
public class LinkManController {
	@Autowired
	private LinkManService ls;
	@RequestMapping("/add")
	@ResponseBody
	public String add(String linkManName,String linkManPhone,String linkManSex,Integer cid) {
		// Customer customer=cs.selectById(cid);
		CusLinkman linkman = new CusLinkman(linkManName, linkManPhone, linkManSex,cid);
		ls.add(linkman);
		return "true";

	}




	@RequestMapping("/toLink")
	public String tolink(Model model,Integer id){
		System.out.println("tolink中的"+id);
		model.addAttribute("id",id);
		return "customer/list";
	}
	@RequestMapping("/toAddLink")
	public String toAddLink(Model model,Integer id){
		System.out.println("tolink中的"+id);
		model.addAttribute("id",id);
		return "customer/linkmanadd";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(String page,String limit,String lkmname,String lkmphone,Integer id) {
		CusLinkman linkman=new CusLinkman();
		System.out.println("list中的"+id);
		linkman.setCid(id);
		linkman.setLkmname(lkmname);
		linkman.setLkmphone(lkmphone);
		Map<String, Object> map = ls.list(page,limit,linkman);
		return map;
	}



	@RequestMapping("/del")
	@ResponseBody
	public String del(int lkmid) {
		ls.del(lkmid);
		return "true";
		
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(int lkmid,String field,String value) {
		ls.update(lkmid,field,value);
		return "true";
		
	}
}
