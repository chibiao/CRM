package com.tjetc.service;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjetc.mapper.UserMapper;
import com.tjetc.pojo.User;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper;

	public PageListRes list(PageVo pv, User u) {
		PageListRes pageListRes = new PageListRes();
		Page<Object> page = PageHelper.startPage(pv.getPage(), pv.getLimit());
		List<User> list = mapper.list(u);
		pageListRes.setCode(0);
		pageListRes.setData(list);
		pageListRes.setCount(page.getTotal());
		return pageListRes;
	}

	public void update(User u) {
		mapper.update(u);
	}

	public void del(int id) {
		mapper.del(id);

	}

	public void delBySelect(List<Integer> list) {
		mapper.delBySelect(list);
	}

	public void add(User u) {
		Md5Hash md5Hash=new Md5Hash(u.getPassword(),u.getName(),2);
		u.setPassword(md5Hash.toString());
		mapper.add(u);
	}
	
	public User getByName(String username) {
		// TODO Auto-generated method stub
		return mapper.getByName(username);
	}

	public List<String> getRolesById(int id) {
		return mapper.getRolesById(id);
	}

	public List<String> getPermissionById(int id) {
		return mapper.getPermissionById(id);
	}

}
