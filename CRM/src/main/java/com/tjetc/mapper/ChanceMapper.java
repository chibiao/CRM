package com.tjetc.mapper;

import java.util.List;
import com.tjetc.pojo.Chance;

public interface ChanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chance record);

    Chance selectByPrimaryKey(Integer id);

    List<Chance> selectAll();

    int updateByPrimaryKey(Chance record);
}