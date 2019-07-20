package com.tjetc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.CusRank;
import com.tjetc.pojo.Customer;
import com.tjetc.pojo.Plan;
import com.tjetc.pojo.User;
import com.tjetc.service.PlanService;
import com.tjetc.service.SalesService;
import com.tjetc.service.impl.CustomerService;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	private PlanService planService;
	@Autowired
	private CustomerService service;
	@Autowired
	private SalesService salesService;

	@RequestMapping("/planList/{id}")
	@ResponseBody
	public PageListRes planList(@PathVariable Integer id) {
		System.out.println("aaa");
		return planService.planList(id);
	}
	
	@PostMapping("/addPlan")
	@ResponseBody
	public AjaxRes addPlan(Plan plan){
		return planService.addPlan(plan);
	}

	// 改变执行计划的状态
	@RequestMapping("/changeState")
	@ResponseBody
	public AjaxRes changeState(Integer id) {
		return planService.changeState(id);
	}
	// 改变执行计划的状态
	@RequestMapping("/deletePlan")
	@ResponseBody
	public AjaxRes deletePlan(Integer id) {
		return planService.deletePlan(id);
	}
	// 改变执行计划的状态
	@RequestMapping("/chanceList")
	@ResponseBody
	public PageListRes chanceList(PageVo pv) {
		return planService.chanceList(pv);
	}
	
	// 改变执行计划的状态
	@RequestMapping("/getManager")
	public String getManager(Model model) {
		List<User> userlist= service.getUserList();

		List<CusRank> ranklist= service.getRankList();

		model.addAttribute("userlist",userlist);
		model.addAttribute("ranklist",ranklist);
		
		return "/chance/plan_list";
	}
	
	// 改变执行计划的状态
	@RequestMapping("/addCustomer")
	@ResponseBody
	public boolean addCustomer(Customer customer,int chanceid) {
		System.out.println(customer);
		System.out.println(chanceid);
		Date d = new Date();
		String formatted = new SimpleDateFormat ("yyyy-MM-dd:HH-mm-ss").format (d);
		String replaceAll = formatted.replaceAll("-", "");
		String replaceAll2 = replaceAll.replaceAll(":", "");
		String cusid="CRM"+replaceAll2;
		customer.setCusid(cusid);
		service.add(customer);
		salesService.deleteChance(chanceid);
		return true;
	}
	
}
