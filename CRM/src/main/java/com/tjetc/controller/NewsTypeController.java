package com.tjetc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.Newstype;
import com.tjetc.service.impl.NewsTypeService;
import com.tjetc.utils.PageListRes;

@Controller
@RequestMapping("/newsType")
public class NewsTypeController {
	@Autowired
	private NewsTypeService ns;
	
	@RequestMapping("list")
	@ResponseBody
	public PageListRes list(Model m,String typeonename,String page,String limit){
		typeonename=typeonename==null?"":typeonename;
		int count=ns.getCount(typeonename);
		List<Newstype> list=ns.list(typeonename,page,limit);
		PageListRes pageListRes = new PageListRes();
		pageListRes.setCode(0);
		m.addAttribute("count", count);
		pageListRes.setCount(count);
		pageListRes.setData(list);
		
		return pageListRes ;
	}
	@RequestMapping("/del")
	public void del(int id){
		ns.del(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(Newstype n){
		return ns.update(n);
	}
	@RequestMapping("/add")
	@ResponseBody
	public String add(Newstype n){
		return ns.add(n);
	}
}
