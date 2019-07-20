package com.tjetc.mapper;

import com.tjetc.pojo.Chance;
import com.tjetc.pojo.Plan;
import com.tjetc.utils.PageVo;

import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    Plan selectByPrimaryKey(Integer id);

    List<Plan> selectAll();

    int updateByPrimaryKey(Plan record);

	void changeState(Integer id);

	List<Plan> planList(Integer id);

	List<Chance> chanceList(PageVo pv);
}