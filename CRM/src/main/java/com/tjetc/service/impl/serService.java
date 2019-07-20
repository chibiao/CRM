package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.SerCjMapper;
import com.tjetc.mapper.SerClMapper;
import com.tjetc.mapper.SerTypeMapper;
import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerCl;
import com.tjetc.pojo.SerResult;
import com.tjetc.pojo.SerType;

@Service
public class serService {
	@Autowired
	private SerCjMapper sercjmapper;
	@Autowired
	private SerClMapper serclmapper;
	@Autowired
	private SerTypeMapper sertypeMapper;

	public List<SerCj> listCj() {
		// TODO Auto-generated method stub
		return sercjmapper.listCj();
	}

	/*public List<SerCl> listCl() {
		// TODO Auto-generated method stub
		return serclmapper.list();
	}*/

	public List<SerType> listType() {
		// TODO Auto-generated method stub
		return sertypeMapper.list();
	}

	public SerCj getById(String id) {
		return sercjmapper.getByIdz(id);
	}

	public Map<String, Object> getMap(String custom, String id, int type, int currentPage, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> maplist = new HashMap<String, Object>();
		PageHelper.startPage(currentPage,pageSize);
		maplist.put("custom",custom);
		maplist.put("id",id);
		maplist.put("types", type);
		List<SerCj> teaList1 = sercjmapper.teaList2(maplist);
		System.out.println(teaList1);
		PageInfo<SerCj> pageInfo = new PageInfo<SerCj>(teaList1);
	
		map.put("teaList1", teaList1);
		map.put("page", pageInfo);
		return map;
	}

	public void updateGui(String id) {
		sercjmapper.updateGui(id);
	}

	public void updateFen(String id) {
		sercjmapper.updateFen(id);
	}

	public void addRes(SerResult serResult) {
		sercjmapper.addRes(serResult);
	}

	public Map<String, Object> getMapGui(String custom, String id, int type, int currentPage, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> maplist = new HashMap<String, Object>();
		PageHelper.startPage(currentPage,pageSize);
		maplist.put("custom",custom);
		maplist.put("id",id);
		maplist.put("types", type);
		List<SerCj> teaList1 = sercjmapper.teaListGui(maplist);
		PageInfo<SerCj> pageInfo = new PageInfo<SerCj>(teaList1);
	
		map.put("teaList1", teaList1);
		map.put("page", pageInfo);
		return map;
	}

	public SerCj getByIdGui(String id) {
		// TODO Auto-generated method stub
		return sercjmapper.getByIdz(id);
	}

	public SerResult getResult(String id) {
		// TODO Auto-generated method stub
		return sercjmapper.getResult(id);
	}

	public void updateRes(SerResult serResultAdd) {
		sercjmapper.updateRes(serResultAdd);
	}
	
}
