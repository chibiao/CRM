package com.tjetc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjetc.mapper.ChanceMapper;
import com.tjetc.pojo.Chance;
import com.tjetc.pojo.User;
import com.tjetc.service.SalesService;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;
@Service
public class SalesServiceImpl implements SalesService{
	@Autowired
	private ChanceMapper chanceMapper;
	@Override
	public PageListRes chanceList(PageVo pv) {
		PageListRes pageListRes = new PageListRes();
		Page<Object> page = PageHelper.startPage(pv.getPage(), pv.getLimit());
		List<Chance> chances = chanceMapper.selectAll(pv);
		pageListRes.setCode(0);
		pageListRes.setCount(page.getTotal());
		pageListRes.setData(chances);
		return pageListRes;
	}
	@Override
	public AjaxRes addChange(Chance chance) {
		AjaxRes ajaxRes = new AjaxRes();
		chance.setCreattime(new Date());
		try {
			chanceMapper.insert(chance);
			ajaxRes.setMsg("添加成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			ajaxRes.setMsg("添加失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public AjaxRes updateChance(Chance chance) {
		AjaxRes ajaxRes = new AjaxRes();
		try {
			chanceMapper.updateByPrimaryKey(chance);
			ajaxRes.setMsg("修改成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			ajaxRes.setMsg("修改失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public AjaxRes deleteChance(Integer id) {
		AjaxRes ajaxRes = new AjaxRes();
		try {
			chanceMapper.deleteByPrimaryKey(id);
			ajaxRes.setMsg("删除成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			ajaxRes.setMsg("删除失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public List<User> getUser() {
		return chanceMapper.selectUser();
	}
}
