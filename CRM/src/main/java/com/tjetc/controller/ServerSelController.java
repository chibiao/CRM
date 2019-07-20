package com.tjetc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerSel;
import com.tjetc.service.impl.ServerService;


@Controller
@RequestMapping("/Ssel")
public class ServerSelController {
	@Autowired
	ServerService ss =new ServerService();
	
	@RequestMapping("/sel")
	@ResponseBody
	public List<SerSel> sel(String ctime) {
		ctime = (ctime == null||"全部".equals(ctime)) ? "" : ctime;
		List<SerSel> list = ss.sel(ctime);
		return list;
	}

	@RequestMapping("/sel2")
	@ResponseBody
	public Map<String, Object> sel2(String ctime) {
		List<SerSel> list1 = sel("2015");
		List<SerSel> list2 = sel("2016");
		List<SerSel> list3 = sel("2017");
		List<SerSel> list4 = sel("2018");
		List<SerSel> list5 = sel("2019");
		Map<String, Object> map =new HashMap<>();
		map.put("sel1", list1);
		map.put("sel2", list2);
		map.put("sel3", list3);
		map.put("sel4", list4);
		map.put("sel5", list5);
		return map;
	}
}
