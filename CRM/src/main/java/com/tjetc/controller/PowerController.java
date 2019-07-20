package com.tjetc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import com.tjetc.pojo.Power;
import com.tjetc.pojo.Role;

import com.tjetc.service.impl.PowerServiceImpl;
import com.tjetc.service.impl.RoleServiceImpl;


@Controller
@RequestMapping("/power")
public class PowerController {
	@Autowired
	private PowerServiceImpl powerServiceImpl;
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	@RequestMapping("/list")
	public String list(Role role,Model model,String name,String curpage){
		int pageSize=10;
		role.setName(name);
		int currentPage=curpage==null?1:Integer.parseInt(curpage);
		Map<String, Object> map=roleServiceImpl.list(currentPage,pageSize,role);
		model.addAttribute("roleList",map.get("list"));
		model.addAttribute("role",role);
		model.addAttribute("name", name);
		model.addAttribute("pageInfo",map.get("pageInfo"));
		return "/distPower/RolePower";
		
	}
	
	//跳转至添加角色以及分配权限界面
	@RequestMapping("/toaddRole")
	public String powerList(Model model){
		List<Power> powerList=powerServiceImpl.list();
		List<Power> sonList=powerServiceImpl.sonList();
		model.addAttribute("powerList",powerList);
		model.addAttribute("sonList",sonList);
		return "/distPower/addRole";
	}
	
	//添加角色以及分配权限界面
		@RequestMapping("/addRole")
		public String addRolePower(String name, String powers,String des){
			Role role=new Role();
			role.setName(name);
			role.setDes(des);
			roleServiceImpl.add(role);
			int rid = role.getId();
			try {
				String[] rpower = powers.split(",");
				for (String repower : rpower) {
					Power power = powerServiceImpl.selectId(repower);
					int pid = power.getId();
					powerServiceImpl.insert(rid,pid);
				}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "redirect:/power/list";
		}
		
		
		
		
		//带参跳转至权限修改界面
		@RequestMapping("/toRolePowerEdit")
		public String toRolePowerEdit(Integer id,Model model){
			Role role=roleServiceImpl.selectById(id);
			System.out.println(role);
		 //所有的权限
			List<Power> powerList=powerServiceImpl.list();
			List<Power> sonList=powerServiceImpl.sonList();
			//拥有的权限
			List<Power> idList=powerServiceImpl.selectPidById(id);
				//传至RolePowerEdit.jsp界面	
			model.addAttribute("powerList",powerList);
			model.addAttribute("sonList",sonList);
			model.addAttribute("idList",idList);
			model.addAttribute("id",id);
			model.addAttribute("role",role);
			
			
			return "/distPower/RolePowerEdit";
			
		}
		
		//权限修改界面
				@RequestMapping("/RolePowerEdit")
				public String RolePowerEdit( String powers,Integer id){
					powerServiceImpl.delById(id);
					int rid = id;
					try {
						String[] rpower = powers.split(",");
						for (String repower : rpower) {
							Power power = powerServiceImpl.selectId(repower);
							int pid = power.getId();
							powerServiceImpl.insert(rid,pid);
						}	
					} catch (Exception e) {
					}
					return "redirect:/power/list";
				}
	/*//添加一级权限
	@RequestMapping("/addpower")
	public String addpower(String name){
		Power power=powerServiceImpl.addpower(name);
		//重定向
		return "redirect:/power/list";
		
		
		
	}*/
	
	/*//删除一级权限
	@RequestMapping("{id}/deletpower")
	public String delete(@PathVariable("id") Integer id){
		powerServiceImpl.del(id);
		System.out.println("-------------"+id);
		return "redirect:/power/list";
	}*/
	/*//删除角色
		@RequestMapping("{id}/deleteRole")
		public String delete(@PathVariable("id") Integer id){
			roleServiceImpl.del(id);
			System.out.println("-------------"+id);
			return "redirect:/power/list";
		}*/
	
	

}
