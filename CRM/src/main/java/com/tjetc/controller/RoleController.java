package com.tjetc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tjetc.pojo.Role;
import com.tjetc.pojo.User;
import com.tjetc.service.impl.RoleServiceImpl;
import com.tjetc.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserServiceImpl uServiceImpl;
	@Autowired
	private RoleServiceImpl rServiceImpl;
	
	@RequestMapping("/update")
	public String update(String role,Model model,Integer id){
		rServiceImpl.deleteById(id);
		int uid=id;;
		try {
			//分割
			String[] roles = role.split(",");
			//循环添加
			for (String rol : roles) {
				Role ro = rServiceImpl.selectId(rol);
				int rid = ro.getId();
				uServiceImpl.insert(uid,rid);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("update");
		return "role/user-list";		
	}
	
	//获取编辑信息
	@RequestMapping("/getById")
	public String getUserById(Integer id,Model model){
		User user=uServiceImpl.getUserById(id);
		List<Role> rList= rServiceImpl.getRole();
		List<Role> List=uServiceImpl.getAllById(id);
		System.out.println(user);
		System.out.println(rList);
		System.out.println(List);
		model.addAttribute("user",user);
		model.addAttribute("rList",rList);
		model.addAttribute("List",List);
		return "role/edit";
	}
	
	@RequestMapping("/user-list")
	@ResponseBody
	public Map<String, Object> list(String curr,String nums){
		System.out.println("$$$$$");		
		Map<String,Object> map=uServiceImpl.list( curr, nums);
		return map;
	}
}
