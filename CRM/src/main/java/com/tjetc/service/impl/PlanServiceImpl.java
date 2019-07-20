package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjetc.mapper.PlanMapper;
import com.tjetc.pojo.Chance;
import com.tjetc.pojo.Plan;
import com.tjetc.service.PlanService;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;
@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanMapper planMapper;
	@Override
	public PageListRes planList(PageVo pv) {
		PageListRes pageListRes = new PageListRes();
		Page<Object> page = PageHelper.startPage(pv.getPage(), pv.getLimit());
		List<Plan> plans = planMapper.selectAll();
		pageListRes.setCode(0);
		pageListRes.setCount(page.getTotal());
		pageListRes.setData(plans);
		return pageListRes;
	}
	@Override
	public AjaxRes changeState(Integer id) {
		AjaxRes ajaxRes = new AjaxRes();
		try {
			planMapper.changeState(id);
			ajaxRes.setMsg("修改成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxRes.setMsg("修改失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public AjaxRes deletePlan(Integer id) {
		AjaxRes ajaxRes = new AjaxRes();
		try {
			planMapper.deleteByPrimaryKey(id);
			ajaxRes.setMsg("删除成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxRes.setMsg("删除失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public AjaxRes addPlan(Plan plan) {
		AjaxRes ajaxRes = new AjaxRes();
		try {
			planMapper.insert(plan);
			ajaxRes.setMsg("添加成功");
			ajaxRes.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxRes.setMsg("添加失败");
			ajaxRes.setSuccess(false);
		}
		return ajaxRes;
	}
	@Override
	public PageListRes planList(Integer id) {
		PageListRes pageListRes = new PageListRes();
		List<Plan> plans=planMapper.planList(id);
		pageListRes.setCode(0);
		pageListRes.setData(plans);
		return pageListRes;
	}
	@Override
	public PageListRes chanceList(PageVo pv) {
		PageListRes pageListRes = new PageListRes();
		Page<Object> page = PageHelper.startPage(pv.getPage(), pv.getLimit());
		List<Chance> list = planMapper.chanceList(pv);
		pageListRes.setCode(0);
		pageListRes.setData(list);
		pageListRes.setCount(page.getTotal());
		return pageListRes;
	}

}
