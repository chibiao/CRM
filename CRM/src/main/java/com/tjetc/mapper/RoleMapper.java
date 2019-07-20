package com.tjetc.mapper;

import java.util.HashMap;
import java.util.List;

import com.tjetc.pojo.Role;

public interface RoleMapper {

	void del(Integer id);



	List<Role> list(Role role);



	void add(Role role);



	Role selectById(Integer id);
	
	
	
	
	List<Role> getRole();
	
	List<Role> getRoleById(int id);

	List<Role> getAllById(Integer id);

	void deleteById(Integer id);

	Role selectId(String rol);

	void insert(HashMap<String, Integer> map);

}
