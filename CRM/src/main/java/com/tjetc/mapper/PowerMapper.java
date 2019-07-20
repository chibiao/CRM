package com.tjetc.mapper;

import java.util.List;

import org.apache.commons.collections4.map.HashedMap;

import com.tjetc.pojo.Power;

public interface PowerMapper {

	List<Power> list();

	

	void addpower(String name);

	void del(Integer id);



	List<Power> sonList();



	Power selectId(String string);


	void insert(HashedMap<String, Integer> map);



	List<Power> selectPidById(Integer id);


	//通过role id删除权限 即权限清空
	void delById(Integer id);



}
