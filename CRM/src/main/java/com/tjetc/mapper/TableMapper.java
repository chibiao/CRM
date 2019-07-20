package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.CusLost;
import com.tjetc.pojo.LostReason;

public interface TableMapper {
    //查询 lostReason表  id--name
	List<LostReason> listLostReason();
	//找各个原因对应的数量
	int getcount1();
	int getcount2();
	int getcount3();
	int getcount4();
	//各个年份
		//原因1
		int selectByYear11();
		int selectByYear12();
		int selectByYear13();
		//原因2
		int selectByYear21();
		int selectByYear22();
		int selectByYear23();
		//原因3
		int selectByYear31();
		int selectByYear32();
		int selectByYear33();
		//原因4
		int selectByYear41();
		int selectByYear42();
		int selectByYear43();
	//条件查询
		List<CusLost> list(CusLost cusLost);
}
