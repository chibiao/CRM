package com.tjetc.service;

import java.util.List;

import com.tjetc.pojo.Chance;
import com.tjetc.pojo.User;
import com.tjetc.utils.AjaxRes;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

public interface SalesService {

	PageListRes chanceList(PageVo pv);

	AjaxRes addChange(Chance chance);

	AjaxRes updateChance(Chance chance);

	AjaxRes deleteChance(Integer id);

	List<User> getUser();

}
