package com.tjetc.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.PowerMapper;

import com.tjetc.pojo.Power;

@Service
public class PowerServiceImpl {

	
	@Autowired
	private PowerMapper powerMapper;

	public PowerServiceImpl(PowerMapper powerMapper) {
		super();
		this.powerMapper = powerMapper;
	}

//查询所有一级权限
	public List<Power> list() {
		 
		return powerMapper.list();
	}


	//添加一级权限 
	public Power addpower(String name) {
		// TODO Auto-generated method stub
		powerMapper.addpower(name);
		return null;
		
	}

	public void del(Integer id) {
		powerMapper.del(id);
		
	}

	public List<Power> sonList() {
		// TODO Auto-generated method stub
		return powerMapper.sonList();
	}

	public void select(String powers) {
		// TODO Auto-generated method stub
		
	}

	public Power selectId(String string) {
		// TODO Auto-generated method stub
		return powerMapper.selectId(string);
	}

	public void insert(int rid, int pid) {
		// TODO Auto-generated method stub
		HashedMap<String,Integer> map = new HashedMap<>();
		map.put("rid", rid);
		map.put("pid", pid);
		powerMapper.insert(map);
	}

	public List<Power> selectPidById(Integer id) {
		
		return powerMapper.selectPidById(id);
	}

	public void delById(Integer id) {
		// TODO Auto-generated method stub
		powerMapper.delById(id);
	}

	
	
	
	
	
}
