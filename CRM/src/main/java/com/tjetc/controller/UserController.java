package com.tjetc.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tjetc.pojo.User;
import com.tjetc.service.UserService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us; 
	
	@RequestMapping("/list")
	@ResponseBody
	public PageListRes list(PageVo pv,Integer id,String name,String email,String sex){
		User u = new User();
		u.setId(id=id==null?0:id);
		u.setName(name);
		u.setEmail(email);
		u.setSex(sex);
		System.out.println(u);
		return us.list(pv,u);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update( User u){
		Map<String, Object> map = new HashMap<>();
		 try {
            us.update(u);
	 		map.put("msg", "添加成功");
	 		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			map.put("msg","修改失败");
			map.put("success", false);
		}
		return map;
	}
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> del(int id){
		Map<String, Object> map = new HashMap<>();
		try {
			us.del(id);
			map.put("msg", "刪除成功");
			map.put("success", true);
		} catch (Exception e) {
			map.put("msg","刪除失败");
			map.put("success", false);
		}
		return map;
	}
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(@RequestParam(value="file2",required=false) MultipartFile file2, User u, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		 try {
			 String path = request.getSession().getServletContext().getRealPath("static/image/user");
	         String pathPhoto = "/static/image/user";
	         if(!file2.isEmpty()){
	             String name = file2.getOriginalFilename();//获取接受到的图片名称
	             String newFileName = UUID.randomUUID().toString().substring(0,5)+"."+ FilenameUtils.getExtension(name);
	             File fi = new File(path,newFileName);       //将path路径与图片名称联系在一起
	             if(!fi.getParentFile().exists()){    //判断是否存在path路径下的文件夹
	                 fi.getParentFile().mkdirs();       //不存在创建path路径下的文件夹
	             }
	             file2.transferTo(fi);                        //上传图片
	             u.setImage(pathPhoto+"/"+newFileName);   //为保存图片路径
	             us.add(u);
	 			map.put("msg", "添加成功");
	 			map.put("success", true);
	         }
		} catch (Exception e) {
			map.put("msg","添加失败");
			map.put("success", false);
		}
		return map;
	}
	
	@RequestMapping(value = "/delBySelect", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delBySelect(@RequestBody  List<Integer> list){
		Map<String, Object> map = new HashMap<>();
		try {
			us.delBySelect(list);
			map.put("msg", "刪除成功");
			map.put("success", true);
		} catch (Exception e) {
			map.put("msg","刪除失败");
			map.put("success", false);
		}
		return map;
	}
	
	@RequestMapping("/valUser")
	@ResponseBody
	public boolean valUser(String username,String password,HttpServletRequest request){
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		System.out.println(username+"-----"+password);
		User user2 = us.getByName(username);
		if(user2==null){
			return false;
		}else{
			String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
			System.out.println(user2);
			if(user2.getPassword().equals(md5)){
				request.getSession().setAttribute("user", user2);
				return true;
			}else{
				return false;
			}
		}
	}

}
