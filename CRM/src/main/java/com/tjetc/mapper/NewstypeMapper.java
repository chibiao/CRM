package com.tjetc.mapper;

import com.tjetc.pojo.Newstype;
import com.tjetc.pojo.NewstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewstypeMapper {
    int countByExample(NewstypeExample example);

    int deleteByExample(NewstypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Newstype record);

    int insertSelective(Newstype record);

    List<Newstype> selectByExample(NewstypeExample example);

    Newstype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Newstype record, @Param("example") NewstypeExample example);

    int updateByExample(@Param("record") Newstype record, @Param("example") NewstypeExample example);

    int updateByPrimaryKeySelective(Newstype record);

    int updateByPrimaryKey(Newstype record);
    
    List<Newstype> findAll();
    
}