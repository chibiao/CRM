package com.tjetc.mapper;

import com.tjetc.pojo.CusLinkman;
import com.tjetc.pojo.CusLinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CusLinkmanMapper {
    int countByExample(CusLinkmanExample example);

    int deleteByExample(CusLinkmanExample example);

    int deleteByPrimaryKey(Integer lkmid);

    int insert(CusLinkman record);

    int insertSelective(CusLinkman record);

    List<CusLinkman> selectByExample(CusLinkmanExample example);

    CusLinkman selectByPrimaryKey(Integer lkmid);

    int updateByExampleSelective(@Param("record") CusLinkman record, @Param("example") CusLinkmanExample example);

    int updateByExample(@Param("record") CusLinkman record, @Param("example") CusLinkmanExample example);

    int updateByPrimaryKeySelective(CusLinkman record);

    int updateByPrimaryKey(CusLinkman record);

	List<CusLinkman> list(CusLinkman cuslinkman);
}