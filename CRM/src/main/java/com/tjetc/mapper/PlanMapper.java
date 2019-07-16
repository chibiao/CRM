package com.tjetc.mapper;

import com.tjetc.pojo.Plan;
import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    Plan selectByPrimaryKey(Integer id);

    List<Plan> selectAll();

    int updateByPrimaryKey(Plan record);
}