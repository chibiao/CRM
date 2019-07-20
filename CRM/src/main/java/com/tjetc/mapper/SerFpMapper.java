package com.tjetc.mapper;

import java.util.List;
import java.util.Map;

import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerFp;

public interface SerFpMapper {

	void add(SerFp serfp);

	List<SerCj> teaList1(Map<String, Object> maplist);

	SerFp getFp(String id);

	void updateFp(SerFp serfp);
	
	

}
