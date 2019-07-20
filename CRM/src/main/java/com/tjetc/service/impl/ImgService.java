package com.tjetc.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.mapper.ImgMapper;
import com.tjetc.pojo.Img;
import com.tjetc.pojo.ImgExample;
import com.tjetc.pojo.ImgExample.Criteria;
import com.tjetc.utils.PageVo;

@Service
public class ImgService {
	@Autowired
	private ImgMapper im;

	public int count() {
		int i = im.countByExample(null);
		return i;
	}

	public List<Img> list(String imgName, PageVo pv) {
		PageHelper.startPage(pv.getPage(), pv.getLimit());
		ImgExample example=new ImgExample();
		Criteria c = example.createCriteria();
		c.andNameLike("%"+imgName+"%");
		List<Img> list = im.selectByExample(example);
		PageInfo<Img> pageInfo = new PageInfo<Img>(list);
		return list;
	}

	public void add(Img img) {
		// TODO Auto-generated method stub
		im.insert(img);
	}

	public void del(int id) {
		// TODO Auto-generated method stub
		im.deleteByPrimaryKey(id);
	}

	public void update(Img i) {
		// TODO Auto-generated method stub
		im.updateByPrimaryKey(i);
	}

	public Img findBtId(int iid) {
		// TODO Auto-generated method stub
		return im.selectByPrimaryKey(iid);
	}

	public List<Img> listall() {
		// TODO Auto-generated method stub
		return im.selectByExample(null);
	}
}
