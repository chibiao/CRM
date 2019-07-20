package com.tjetc.mapper;

import java.util.List;
import java.util.Map;

import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerResult;
import com.tjetc.pojo.User;

public interface SerCjMapper {

	void add(SerCj sercj);

	List<SerCj> listSerCj();

	List<SerCj> teaList1(Map<String, Object> maplist);

	SerCj getById(String id);

	List<User> getIdRole();

	void update(String id);

	SerCj getByIdChuli(String id);

	void updateChuLi(String id);

	//zxt
	 List<SerCj> listCj();

		SerCj getByIdz(String id);

		List<SerCj> teaList2(Map<String, Object> maplist);

		void updateGui(String id);
		
		void updateFen(String id);

		void addRes(SerResult serResult);

		List<SerCj> teaListGui(Map<String, Object> maplist);

		SerResult getResult(String id);

		void updateRes(SerResult serResultUpdate);

	
}
