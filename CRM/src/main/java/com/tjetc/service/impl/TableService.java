package com.tjetc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.CustomerMapper;
import com.tjetc.mapper.TableMapper;
import com.tjetc.pojo.CusLost;
import com.tjetc.pojo.CustomerAnalyze;
import com.tjetc.pojo.LostReason;

@Service
public class TableService {
@Autowired 
private CustomerMapper mapper;
@Autowired
private TableMapper tabMapper;

public List<CustomerAnalyze> listrank() {
	 List<CustomerAnalyze> list = mapper.listrank();
	return list;
}

public List<CustomerAnalyze> listCre() {
	List<CustomerAnalyze> list = mapper.listCre();
	return list;
}

public List<CustomerAnalyze> listSati() {
	List<CustomerAnalyze> list = mapper.listSati();
	return list;
}

public List<CustomerAnalyze> list() {
	List<CustomerAnalyze> list = mapper.list1();
	return list;
}

public List<CustomerAnalyze> list2() {
	List<CustomerAnalyze> list = mapper.list2();
	return list;
}
//
public List<LostReason> listLostReason() {
	//查询流失原因表  id-name
	return tabMapper.listLostReason();
}
public int getcount1() {
	//找各个原因对应的数量
	return tabMapper.getcount1();
}
public int getcount2() {
	//找各个原因对应的数量
	return tabMapper.getcount2();
}
public int getcount3() {
	//找各个原因对应的数量
	return tabMapper.getcount3();
}
public int getcount4() {
	//找各个原因对应的数量
	return tabMapper.getcount4();
}
public int selectByYear11() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear11();
}
public int selectByYear12() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear12();
}
public int selectByYear13() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear13();
}
public int selectByYear21() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear21();
}
public int selectByYear22() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear22();
}
public int selectByYear23() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear23();
}
public int selectByYear31() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear31();
}
public int selectByYear32() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear32();
}
public int selectByYear33() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear33();
}
public int selectByYear41() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear41();
}
public int selectByYear42() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear42();
}
public int selectByYear43() {
	// TODO Auto-generated method stub
	return tabMapper.selectByYear43();
}
public List<CusLost> list(CusLost cusLost) {
	// TODO Auto-generated method stub
	return tabMapper.list(cusLost);
}
}
