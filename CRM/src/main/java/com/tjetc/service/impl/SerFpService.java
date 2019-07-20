package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.SerFpMapper;
import com.tjetc.mapper.SerTypeMapper;
import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerCl;
import com.tjetc.pojo.SerFp;

@Service
public class SerFpService {
	@Autowired
	private SerFpMapper mapper;
	public void add(SerFp serfp) {
		mapper.add(serfp);
		
	}
	public Map<String, Object> getMap(String custom, String id, int type, int currentPage, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> maplist = new HashMap<String, Object>();
		PageHelper.startPage(currentPage,pageSize);
		maplist.put("custom",custom);
		maplist.put("id",id);
		maplist.put("types", type);
		List<SerCj> teaList1 = mapper.teaList1(maplist);
		System.out.println(teaList1);
		PageInfo<SerCj> pageInfo = new PageInfo<SerCj>(teaList1);
		System.out.println("---------"+teaList1);
		map.put("teaList1", teaList1);
		map.put("page", pageInfo);
		return map;
	}
	public SerFp getFp(String id) {
		// TODO Auto-generated method stub
		return mapper.getFp(id);
	}
	public void updateFp(SerFp serfp) {
		mapper.updateFp(serfp);
	}
	
	
	
}
