package com.tjetc.mapper;

import com.tjetc.pojo.CusLost;
import com.tjetc.pojo.CusLostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CusLostMapper {
    int countByExample(CusLostExample example);

    int deleteByExample(CusLostExample example);

    int deleteByPrimaryKey(Integer lostid);

    int insert(CusLost record);

    int insertSelective(CusLost record);

    List<CusLost> selectByExample(CusLostExample example);

    CusLost selectByPrimaryKey(Integer lostid);

    int updateByExampleSelective(@Param("record") CusLost record, @Param("example") CusLostExample example);

    int updateByExample(@Param("record") CusLost record, @Param("example") CusLostExample example);

    int updateByPrimaryKeySelective(CusLost record);

    int updateByPrimaryKey(CusLost record);

	List<CusLost> list();
}