package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.RoleMapper;
import com.tjetc.pojo.Role;

@Service
public class RoleServiceImpl {
	
	@Autowired
	private RoleMapper roleMapper;

	public RoleServiceImpl(RoleMapper roleMapper) {
		super();
		this.roleMapper = roleMapper;
	}

	/*public List<Role> list(String name) {
		// TODO Auto-generated method stub
		return roleMapper.list(name);
	}*/

	

	public void del(Integer id) {
		// TODO Auto-generated method stub
		roleMapper.del(id);
	}

	public Map<String, Object> list(int currentPage, int pageSize, Role role) {
		PageHelper.startPage(currentPage,pageSize);
		
		List<Role> list=roleMapper.list(role);
		PageInfo<Role> pageInfo=new PageInfo<Role>(list);
		if(pageInfo.getNextPage()==0){
			pageInfo.setNextPage(pageInfo.getNavigateLastPage());
		}
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageInfo", pageInfo);
		return map;
	}

	public void add(Role role) {
		// TODO Auto-generated method stub
		 roleMapper.add(role); 
	}

	public Role selectById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectById(id);
	}
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleMapper.getRole();
	}
	public void deleteById(Integer id) {
		roleMapper.deleteById(id);
		
	}
	public Role selectId(String rol) {
		// TODO Auto-generated method stub
		return roleMapper.selectId(rol);
	}
	

}
