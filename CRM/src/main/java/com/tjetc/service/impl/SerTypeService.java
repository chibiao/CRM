package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.SerTypeMapper;
import com.tjetc.pojo.SerType;
@Service
public class SerTypeService {
	@Autowired
	private SerTypeMapper mapper;
	public List<SerType> listType() {
		
		return mapper.list();
	}

}
