package com.tjetc.controller.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.tjetc.mapper.UserMapper;
import com.tjetc.pojo.User;
import com.tjetc.service.UserService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;

	/* 授权 */
	/*
	 * web doGetAuthorizationInfo什么时候调用 1.发现访问路径对应的方法上面有授权的注解
	 * 就会调用doGetAuthorizationInfo 2.页面当中有授权标签,也会调用doGetAuthorizationInfo
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("来了");
		System.out.println("授权调用---");
		User user = (User) principals.getPrimaryPrincipal();
		List<String> roles = new ArrayList<>();
		List<String> permissions = new ArrayList<>();
		/* 查询角色 */
		roles = userService.getRolesById(user.getId());
		/* 查询权限 */
		permissions = userService.getPermissionById(user.getId());
		/*给授权信息*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
	}

	/* 认证 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("AuthenticationInfo来了");
		String username = (String) token.getPrincipal();
		User user = userMapper.getByName(username);
		System.out.println(user);
		if (user == null) {
			return null;
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,
				user.getPassword(), ByteSource.Util.bytes(user.getName()),
				this.getName());
		return info;
	}

}
