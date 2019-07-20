package com.tjetc.mapper;

import com.tjetc.pojo.Customer;
import com.tjetc.pojo.CustomerAnalyze;
import com.tjetc.pojo.OrderCustomer;
import com.tjetc.pojo.Orders;
import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.CusLinkman;
import com.tjetc.pojo.CusRank;
import com.tjetc.pojo.Customer;
import com.tjetc.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface CustomerMapper {
	
	List<CustomerAnalyze> listrank();
	List<CustomerAnalyze> listCre();
	List<CustomerAnalyze> listSati();
	List<CustomerAnalyze> list1();
	List<CustomerAnalyze> list2();
	//
	 int deleteByPrimaryKey(Integer id);

	    int insert(Customer record);

	    Customer selectByPrimaryKey(Integer id);

	    List<Customer> selectAll();

	    int updateByPrimaryKey(Customer record);
	    
	    List<OrderCustomer> selectOandC();
	    
	List<Orders> selectCtoObyCid(String name);
	List<Customer> list();
	int getCount();
	Customer getById(int cid);
	void del(int cid);
	List<CusLinkman> getLinkMansByCid(int cid);
	List<CusContact> getContact(int cid);
	User getUserById(int userid);
	List<User> getUserList();
	List<CusRank> getRankList();
	void updateCus(@Param("id") int id,@Param("cusStatus") int cusStatus);
	void add(Customer customer);
	void update(Customer customer);
   
}