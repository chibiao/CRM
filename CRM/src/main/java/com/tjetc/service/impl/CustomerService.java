package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.mapper.CustomerMapper;
import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.CusLinkman;
import com.tjetc.pojo.CusRank;
import com.tjetc.pojo.Customer;
import com.tjetc.pojo.OrderCustomer;
import com.tjetc.pojo.Orders;
import com.tjetc.pojo.User;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper mapper;
	public List<Orders> selectByCid(String name){
		return mapper.selectCtoObyCid(name);
	}
	public List<OrderCustomer> list1() {
		return mapper.selectOandC();
	}
	public List<Customer> list(){
		return mapper.list();
	}
	public int getCount(){
		return mapper.getCount();
	}
	public Customer getById(int cid){
		return mapper.getById(cid);
	}
	public void del(int cid){
		 mapper.del(cid);
	}
	public List<CusLinkman> getLinkMansByCid(int cid) {
		// TODO Auto-generated method stub
		return mapper.getLinkMansByCid(cid);
	}
	public List<CusContact> getContact(int cid) {
		// TODO Auto-generated method stub
		return mapper.getContact(cid);
	}
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return mapper.getUserById(userid);
	}
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return mapper.getUserList();
	}
	public List<CusRank> getRankList() {
		// TODO Auto-generated method stub
		return mapper.getRankList();
	}
	public void updateCus(int id, int cusStatus) {
		// TODO Auto-generated method stub
		mapper.updateCus(id,cusStatus);
	}
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		mapper.add(customer);
	}
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		mapper.update(customer);
	}
}
