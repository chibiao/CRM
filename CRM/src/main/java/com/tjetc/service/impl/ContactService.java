package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.CusContactMapper;
import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.Customer;

@Service
public class ContactService {
	@Autowired
	private CusContactMapper conMapper;

	public void add(CusContact contact) {
		conMapper.addContact(contact);

	}

	public void del(Integer conid) {
		conMapper.delContact(conid);
	}

	public CusContact getById(Integer conid) {
		CusContact contact = conMapper.getById(conid);
		return contact;
	}

	public void update(CusContact contact) {
		conMapper.update(contact);
	}
	
	public List<Customer> list(CusContact cusContact) {
		List<Customer> list = conMapper.listContact(cusContact);
		return list;
	}
}
