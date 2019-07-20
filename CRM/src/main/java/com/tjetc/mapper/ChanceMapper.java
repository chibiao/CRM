package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.Chance;
import com.tjetc.pojo.User;
import com.tjetc.utils.PageVo;

public interface ChanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chance record);

    Chance selectByPrimaryKey(Integer id);

    List<Chance> selectAll(PageVo pv);

    int updateByPrimaryKey(Chance record);
    
    List<User> selectUser();
}