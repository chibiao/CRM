package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.SerSel;

public interface ServerMapper {
	List<SerSel> sel(String ctime);
	List<SerSel> sel2();
}
