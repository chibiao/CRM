package com.tjetc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.DataVo;
import com.tjetc.pojo.OrderCustomer;
import com.tjetc.pojo.Orders;
import com.tjetc.service.impl.CustomerService;


@Controller
public class CustomerContributionController {
	@Autowired
	private CustomerService service;
	@RequestMapping("/getlist")
	@ResponseBody
	public Map<String, Object> getlist() {
		List<OrderCustomer> list = service.list1();
		List<String> list1 = new ArrayList<String>();
		List<Double> list2 = new ArrayList<Double>();
		List<Object> list3 = new ArrayList<Object>();
		for (OrderCustomer orderCustomer : list) {
			list1.add(orderCustomer.getName());
			list2.add(orderCustomer.getPrice());
			DataVo dataVo = new DataVo();
			dataVo.setValue(orderCustomer.getPrice());
			dataVo.setName(orderCustomer.getName());
			list3.add(dataVo);
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		return map;
	}
	@RequestMapping("/get")
	@ResponseBody
	public Map<String, Object> get(String m) {
		List<Orders> list = service.selectByCid(m);
		List<String> list4 = new ArrayList<String>();
		List<Double> list5 = new ArrayList<Double>();
		for (Orders Orders : list) {
			list4.add(Orders.getTime());
			list5.add(Orders.getOrdertotal());
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list4", list4);
		map.put("list5", list5);
		return map;
	}
}
