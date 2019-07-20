package com.tjetc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.ServerMapper;
import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerSel;

@Service
public class ServerService {
	@Autowired
	private ServerMapper sm;
	public List<SerSel> sel(String ctime) {
		return sm.sel(ctime);
	}
	
	public List<SerSel> sel2() {
		return sm.sel2();
	}
}
