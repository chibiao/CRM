package com.tjetc.mapper;

import com.tjetc.pojo.Offer;
import com.tjetc.pojo.OfferExample;
import com.tjetc.pojo.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OfferMapper {
    int countByExample(OfferExample example);

    int deleteByExample(OfferExample example);

    int deleteByPrimaryKey(Integer offerId);

    int insert(Offer record);

    int insertSelective(Offer record);

    List<Offer> selectByExample(OfferExample example);

    Offer selectByPrimaryKey(Integer offerId);

    int updateByExampleSelective(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByExample(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKey(Offer record);

    //查询user中角色（职位）为manager（客户经理）的user
	List<User> managerList();

	// 审核报价单的方法
	void examine(Map<String,Object> map);

	void delete(int offerId);

	void updateById(Offer offer);

	List<String> ordersList();
}