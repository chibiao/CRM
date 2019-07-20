package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.NewstypeMapper;
import com.tjetc.pojo.Newstype;
import com.tjetc.pojo.NewstypeExample;
import com.tjetc.pojo.NewstypeExample.Criteria;

@Service
public class NewsTypeService {
	@Autowired
	private NewstypeMapper nm;
	public String add(Newstype t) {
		boolean a=true;
		int i=0;
		// TODO Auto-generated method stub
		List<Newstype> list = nm.selectByExample(null);
		for (Newstype newstype : list) {
			if(newstype.getName().equals(t.getName())){
				a=false;
			}	
		}
		if(a){
			i = nm.insert(t);
		}
		return i+"";
	}
	public List<Newstype> list(String typeonename, String page, String limit) {
		NewstypeExample example=new NewstypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+typeonename+"%");
		PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
		List<Newstype> list = nm.selectByExample(example);
		PageInfo<Newstype> info = new PageInfo<Newstype>(list);
		return list;
	}
	public int getCount(String typeonename) {
		int count;
		NewstypeExample example=new NewstypeExample();
		if(typeonename==null&&typeonename.equals("")){
			count=nm.countByExample(null);
		}else{
			Criteria criteria = example.createCriteria();
			criteria.andNameLike("%"+typeonename+"%");
			count=nm.countByExample(example);
		}
		return count;
	}
	public void del(int id) {
		// TODO Auto-generated method stub
		nm.deleteByPrimaryKey(id);
	}
	public String update(Newstype n) {
		boolean a=true;
		int i=0;
		// TODO Auto-generated method stub
		List<Newstype> list = nm.selectByExample(null);
		for (Newstype newstype : list) {
			if(newstype.getName().equals(n.getName())){
				a=false;
			}	
		}
		if(a){
			i = nm.updateByPrimaryKey(n);
		}
		return i+"";
	}
	
	public List<Newstype> listAllNewsType(){
		return this.nm.findAll();
	}

}
