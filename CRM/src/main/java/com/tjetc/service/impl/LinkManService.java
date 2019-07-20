package com.tjetc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.CusLinkmanMapper;
import com.tjetc.pojo.CusLinkman;

@Service
public class LinkManService {
@Autowired
 private CusLinkmanMapper mapper;

public void add(CusLinkman linkman) {
	mapper.insert(linkman);
	
}

public Map<String, Object> list(String page,String limit, CusLinkman cuslinkman) {
	PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
	List<CusLinkman> list=mapper.list(cuslinkman);
	PageInfo<CusLinkman> pageInfo = new PageInfo<CusLinkman>(list);
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("data", list);
	map.put("code", 0);
	map.put("count",pageInfo.getTotal());
	return map;
}

public CusLinkman getById(int lkmid) {
	// TODO Auto-generated method stub
	return mapper.selectByPrimaryKey(lkmid);
}

public void update(CusLinkman cusLinkman) {
	System.out.println("进入service方法");
	mapper.updateByPrimaryKeySelective(cusLinkman);
	
}

public void update(int lkmid, String field, String value) {
	CusLinkman cuslinkman=new CusLinkman();
	cuslinkman.setLkmid(lkmid);
	if("lkmname".equals(field)) {
		cuslinkman.setLkmname(value);
	}else if("lkmphone".equals(field)) {
		cuslinkman.setLkmphone(value);
	}else if("lkmsex".equals(field)) {
		cuslinkman.setLkmsex(value);
	}
	mapper.updateByPrimaryKeySelective(cuslinkman);
}

public void del(int lkmid) {
	mapper.deleteByPrimaryKey(lkmid);
	
}
}
