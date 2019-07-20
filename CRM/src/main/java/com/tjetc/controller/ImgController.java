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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tjetc.pojo.Img;
import com.tjetc.service.impl.ImgService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.PageVo;
@Controller
@RequestMapping("/Img")
public class ImgController {
	@Autowired
	public ImgService is;
	@RequestMapping("/list")
	@ResponseBody
	public PageListRes list(String imgName,PageVo pv){
		imgName=imgName==null?"":imgName;
		int count=is.count();
		List<Img> list=is.list(imgName,pv);
		PageListRes pr=new PageListRes();
		pr.setCode(0);
		pr.setCount(count);
		pr.setData(list);
		pr.setMsg("");
		return pr;
	}
	@RequestMapping("/listall")
	@ResponseBody
	public List<Img> listall(){
		List<Img> list=is.listall();
		return list;
	}
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		
		 try {
			 String path = request.getSession().getServletContext().getRealPath("/upload");
	         if(!file.isEmpty()){
	             String name = file.getOriginalFilename();//获取接受到的图片名称
	             String newFileName = UUID.randomUUID().toString().substring(0,5)+"."+ FilenameUtils.getExtension(name);
	             File fi = new File(path,newFileName);       //将path路径与图片名称联系在一起
	             if(!fi.getParentFile().exists()){    //判断是否存在path路径下的文件夹
	                 fi.getParentFile().mkdirs();       //不存在创建path路径下的文件夹
	             }
	             file.transferTo(fi);                        //上传图片
	 			 map.put("msg", "添加成功");
	 			 map.put("success", true);
	 			 map.put("url", "../../upload/"+newFileName);
	         }
	        	
	         
		} catch (Exception e) {
			map.put("msg","添加失败");
			map.put("success", false);
		}
		return map;
	}
	@RequestMapping("/add")
	@ResponseBody
	public String add(String name,String img){
		Img i = new Img();
		if(img==null||img.equals("")){
			return "0";
		}
		i.setName(name);
		i.setPhoto(img);
		is.add(i);
		return "1";
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(String id,String name,String img){
		int iid=Integer.parseInt(id);
		
		if(img==null||img.equals("")){
			Img im=is.findBtId(iid);
			img=im.getPhoto();
		}
		System.out.println(img);
		Img i = new Img();
		i.setId(iid);
		i.setName(name);
		i.setPhoto(img);
		is.update(i);
		return "1";
	}
	@RequestMapping("/del")
	public void del(int id){
		is.del(id);
	}

}
