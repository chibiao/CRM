package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.SerCjMapper;

import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerFp;
import com.tjetc.pojo.User;
@Service
public class SerCjService {
	@Autowired
	private SerCjMapper mapper;
	public void add(SerCj sercj) {
		System.out.println("add()");
		mapper.add(sercj);
	}
	public List<SerCj> listSerCj() {
		
		return mapper.listSerCj();
	}
	public Map<String, Object> getMap(String custom, String id, int type,int currentPage, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> maplist = new HashMap<String, Object>();
		PageHelper.startPage(currentPage,pageSize);
		maplist.put("custom",custom);
		maplist.put("id",id);
		maplist.put("types", type);
		List<SerCj> teaList1 = mapper.teaList1(maplist);
		System.out.println(teaList1);
		PageInfo<SerCj> pageInfo = new PageInfo<SerCj>(teaList1);
	
		map.put("teaList1", teaList1);
		map.put("page", pageInfo);
		return map;
	}
	public SerCj getById(String id) {
		
		return mapper.getById(id);
	}
	public List<User> getIdRole() {
		// TODO Auto-generated method stub
		return mapper.getIdRole();
	}
	public void update(String id) {
		mapper.update(id);
		
	}
	public SerCj getByIdChuli(String id) {
		// TODO Auto-generated method stub
		return mapper.getByIdChuli(id);
	}
	public void updateChuLi(String id) {
		mapper.updateChuLi(id);
		
	}

}
