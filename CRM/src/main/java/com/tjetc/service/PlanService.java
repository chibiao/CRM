package com.tjetc.service;

import com.tjetc.pojo.Plan;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

public interface PlanService {

	PageListRes planList(PageVo pv);

	AjaxRes changeState(Integer id);

	AjaxRes deletePlan(Integer id);

	AjaxRes addPlan(Plan plan);

	PageListRes planList(Integer id);

	PageListRes chanceList(PageVo pv);

}
