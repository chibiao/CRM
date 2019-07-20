package com.tjetc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.SerClMapper;
import com.tjetc.pojo.SerCl;

@Service
public class SerClService {
	@Autowired
	private SerClMapper mapper;

	public SerCl getCl(String id) {
		return mapper.getCl(id);
	}

	public void add(SerCl sercl) {
	mapper.add(sercl);
	}

	public void updateCl(SerCl sercl) {
		mapper.updateCl(sercl);
		
	}
}
