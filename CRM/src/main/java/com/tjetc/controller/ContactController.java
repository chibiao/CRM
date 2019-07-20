package com.tjetc.controller;


import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.Customer;
import com.tjetc.service.impl.ContactService;


@Controller
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService conService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(String condate,String conAddr,String conIfno,String conRemark,Integer cid) {
		CusContact contact=new CusContact(condate,conAddr,conIfno,conRemark,cid);
		System.out.println(contact.toString());
		conService.add(contact);
		return "true";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(Model model,Integer id) {
		System.out.println("toadd中的"+id);
		model.addAttribute("cid",id);
		return "/customer/con-add";
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public String del(Integer conid) {
		conService.del(conid);
		return "true";
	}
	
	@RequestMapping("/list")
	public String list(Model model,String conAddr, Integer curPage,Integer id) {
		conAddr = conAddr == null ? "" : conAddr;
		curPage = curPage == null ? 1 : curPage;
		PageHelper.startPage(curPage, 999);
		CusContact cusContact = new CusContact();
		cusContact.setConAddr(conAddr);
		cusContact.setCid(id);
		List<Customer> customer= conService.list(cusContact);
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(customer);
		
		Customer cus = new Customer();
		for (Customer customer2 : customer) {
			String cusid = customer2.getCusid();
			String cusname = customer2.getCusname();
			cus.setCusid(cusid);
			cus.setCusname(cusname);
			break;
		}
		
		System.out.println("list中的"+id);
		model.addAttribute("id",id);
		model.addAttribute("cus", cus);
		model.addAttribute("list", customer);
		model.addAttribute("page", pageInfo);
		return "customer/con-list";
	}
	
	@RequestMapping("/getById")
	public String getById(Model model, Integer conid) {
		conid = conid == null ? 0 : conid;
		CusContact contact = conService.getById(conid);
		model.addAttribute("contact", contact);
		return "customer/con-update";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(String conid,String condate,String conAddr,String conIfno,String conRemark,HttpServletRequest request) {
		CusContact contact=new CusContact(Integer.parseInt(conid),condate,conAddr,conIfno,conRemark);
		conService.update(contact);
		return "true";
	}
}
