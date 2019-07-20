package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.RoleMapper;
import com.tjetc.mapper.UserMapper;
import com.tjetc.pojo.Power;
import com.tjetc.pojo.Role;
import com.tjetc.pojo.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserMapper mapper;
	@Autowired
	private RoleMapper romapper;
	
	public Map<String, Object> list(String curr,String nums) {
		 PageHelper.startPage(Integer.parseInt(curr),Integer.parseInt(nums));
		 List<User> list = mapper.list();
		 PageInfo<User> info = new PageInfo<User>(list);
		 Map<String, Object> map=new HashMap<String, Object>();
		 map.put("data", list);
		 map.put("code", 0);
	     map.put("count",(int)info.getTotal());
		 return map;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return mapper.getUserById(id);
	}

	public List<Role> getAllById(Integer id) {
		// TODO Auto-generated method stub
		return romapper.getAllById(id);
	}

	public void insert(int uid, int rid) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("uid", uid);
		map.put("rid", rid);
		romapper.insert(map);
		
	}


	
//	public List<Role> listPower() {
//		// TODO Auto-generated method stub
//		return  romapper.list();
//	}
//
//	public List<Role> getByid(int id) {
//		// TODO Auto-generated method stub
//		return romapper.getById(id);
//	}
//
//	public void addEmp(User user) {
//		// TODO Auto-generated method stub
//		mapper.add(user);
//	}

//	public Map<String, Object> list(int currentPage, int pageSize, User user) {
//		PageHelper.startPage(currentPage, pageSize);
//		List<User> list = mapper.list(user);
//		PageInfo<User> pageInfo = new PageInfo<User>(list);
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("list", list);
//		map.put("pageInfo", pageInfo);
//		return map;
//	}
//
//	public void del(int id) {
//		// TODO Auto-generated method stub
//		mapper.delete(id);
//	}
//
//	public void addRole(List<Role> role) {
//		// TODO Auto-generated method stub
//		mapper.add(role);
//	}
//	
	
}
