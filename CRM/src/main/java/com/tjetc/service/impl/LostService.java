package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.CusLostMapper;
import com.tjetc.pojo.CusLost;

@Service
public class LostService {
 @Autowired
 private CusLostMapper mapper;

public Map<String, Object> list() {
	List<CusLost> list=mapper.list();
	System.out.println(list);
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("data", list);
	map.put("code", 0);
	return map;
}

public CusLost getById(int id) {
	CusLost lost = mapper.selectByPrimaryKey(id);
	System.out.println(lost);
	return lost;
}

public void update(CusLost lost) {
	mapper.updateByPrimaryKeySelective(lost);
	
}

public void del(int lostid) {
	mapper.deleteByPrimaryKey(lostid);
	
}
}
