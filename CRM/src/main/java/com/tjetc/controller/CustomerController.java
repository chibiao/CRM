package com.tjetc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.CusLinkman;
import com.tjetc.pojo.CusRank;
import com.tjetc.pojo.Customer;
import com.tjetc.pojo.User;
import com.tjetc.service.impl.CustomerService;


@Controller
@RequestMapping("/CustomerController")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/add")//添加客户
	@ResponseBody
	public boolean add(Customer customer){
		Date d = new Date();
		String formatted = new SimpleDateFormat ("yyyy-MM-dd:HH-mm-ss").format (d);
		String replaceAll = formatted.replaceAll("-", "");
		String replaceAll2 = replaceAll.replaceAll(":", "");
		String cusid="CRM"+replaceAll2;
		customer.setCusid(cusid);
		service.add(customer);
		System.out.println(customer);
		return true;
	}
	@RequestMapping("/addPage")//跳转到addcustomer界面所需要的数据
	public String addPage(Model model){
		
		List<User> userlist= service.getUserList();

		List<CusRank> ranklist= service.getRankList();

		model.addAttribute("userlist",userlist);
		model.addAttribute("ranklist",ranklist);
		
		return "customer/customer-add";
	}
	@RequestMapping("/list")
	public String list(Model model,String page,String limit){
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		List<Customer> list=service.list();
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
		model.addAttribute("cusList",list);
		int count=service.getCount();
		model.addAttribute("count",count);
		model.addAttribute("pageInfo",pageInfo);
		return "customer/customer-list";
	}
	@RequestMapping("/getById")
	public String getById(Model model,int cid){
		System.out.println(cid);
		Customer customer = service.getById(cid);
		model.addAttribute("customer",customer);
		return "customer/customer-info";
	}
	
	@RequestMapping("/editCus")
	public String editCus(Model model,int cid){
		System.out.println(cid);
		Customer customer = service.getById(cid);
		List<User> userlist= service.getUserList();

		List<CusRank> ranklist= service.getRankList();

		model.addAttribute("userlist",userlist);
		model.addAttribute("ranklist",ranklist);
		model.addAttribute("customer",customer);
		return "customer/customer-edit";
	}
	
	@RequestMapping("/updateCus")
	@ResponseBody
	public boolean updateCus(Customer customer){
		Date d = new Date();
		String formatted = new SimpleDateFormat ("yyyy-MM-dd:HH-mm-ss").format (d);
		String replaceAll = formatted.replaceAll("-", "");
		String replaceAll2 = replaceAll.replaceAll(":", "");
		String cusid="CRM"+replaceAll2;
		customer.setCusid(cusid);
		service.update(customer);
		System.out.println(customer);
		return true;
	}
	@RequestMapping("/del")
	public void del(int cid){
		System.out.println(cid);
		service.del(cid);
	}
	@RequestMapping("/changeStatu")
	@ResponseBody
	public String changeStatu(int cid){
		System.out.println("changeStatu()"+cid);
		Customer customer = service.getById(cid);
		int cusStatus=customer.getCusstatus();
		if(cusStatus==1){
			cusStatus=2;
			System.out.println("changeStatu()"+cusStatus+cid);
			service.updateCus(cid,cusStatus);
			return "true";
		}else if(cusStatus==2){
			cusStatus=1;
			service.updateCus(cid,cusStatus);
			return "true";
		}else{
			return "false";
		}

	}
	@RequestMapping("/getCusMore")
	public String getCusMore(Model model,int cid){
		System.out.println(cid);
		//客户全部信息
		Customer customer = service.getById(cid);
		//查询客户经理id
		int userid =customer.getCusmanagerid();
		User user=service.getUserById(userid);
		//客户的联系人信息
		List<CusLinkman> linklist= service.getLinkMansByCid(cid);
		//客户交往记录
		List<CusContact> conlist= service.getContact(cid);

		System.out.println(customer);
		for (CusContact cusContact : conlist) {
			System.out.println(cusContact);
		}
		model.addAttribute("user", user);
		model.addAttribute("customer", customer);
		
		model.addAttribute("linklist", linklist);
		
		model.addAttribute("conlist", conlist);
		return "customer/customer-info";
		
	}
	

}
