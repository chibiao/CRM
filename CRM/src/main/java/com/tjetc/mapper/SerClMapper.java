package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.SerCl;

public interface SerClMapper {

	SerCl getCl(String id);

	void add(SerCl sercl);

	void updateCl(SerCl sercl);
	
	//zxt
	List<SerCl> list();

}
