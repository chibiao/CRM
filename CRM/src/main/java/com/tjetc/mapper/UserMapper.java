package com.tjetc.mapper;

import java.util.List;
import java.util.Map;

import com.tjetc.pojo.User;

public interface UserMapper {
	List<User> list(User u);

	void update(User u);

	void del(int id);

	void delBySelect(List<Integer> list);

	void add(User u);
	
	User getByName(String username);

	List<String> getRolesById(int id);

	List<String> getPermissionById(int id);
	
	List<User> list();

	void update(Map<Integer, Integer> map);

	void clear(int id);

	void add(Map<String, Integer> map);

	User getUserById(int id);

}
