package com.tjetc.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.WebsystemMapper;
import com.tjetc.pojo.Websystem;


@Service
public class WebsystemService {
@Autowired
private WebsystemMapper mapper;

public Websystem getById(int i) {
	// TODO Auto-generated method stub
	return mapper.getById(i);
}

public void update(Websystem ws) {
	mapper.update(ws);
	
}
	

}
