package com.tjetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.Chance;
import com.tjetc.pojo.User;
import com.tjetc.service.SalesService;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

/**
 * 用于营销管理的控制层
 * 
 * @author 迟彪
 */
@Controller
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SalesService salesService;

	/**
	 * 用于请求营销机会页面
	 * 
	 * @return
	 */
	@GetMapping("/chance")
	public String change() {
		return "/change/";
	}

	@GetMapping("/chanceList")
	@ResponseBody
	public PageListRes chanceList(PageVo pv) {
		return salesService.chanceList(pv);
	}

	/**
	 * 接收营销机会 添加营销机会
	 * 
	 * @param chance
	 * @return
	 */
	@PostMapping("addChance")
	@ResponseBody
	public AjaxRes addChange(Chance chance) {
		return salesService.addChange(chance);
	}

	/**
	 * 接收营销机会 修改营销机会
	 * 
	 * @param chance
	 * @return
	 */
	@PostMapping("updateChance")
	@ResponseBody
	public AjaxRes updateChance(Chance chance) {
		return salesService.updateChance(chance);
	}

	@PostMapping("deleteChance")
	@ResponseBody
	public AjaxRes deleteChance(Integer id) {
		return salesService.deleteChance(id);
	}

	@RequestMapping("getUser")
	@ResponseBody
	public List<User> getUser() {
		return salesService.getUser();
	}

}
