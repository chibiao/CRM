package com.tjetc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tjetc.pojo.News;
import com.tjetc.pojo.Newstype;
import com.tjetc.service.NewsService;
import com.tjetc.service.impl.NewsTypeService;
import com.tjetc.utils.PageListRes;
import com.tjetc.utils.QueryVo;

@Controller
@RequestMapping("/News")
public class NewController {
	@Resource
	private NewsService newsservice;
	@Resource
	private NewsTypeService ns;
	/**
	 * 查询操作
	 * @param vo
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public PageListRes listNews(QueryVo vo){
		return this.newsservice.listNews(vo);
	}
	/**
	 * 增加新闻
	 * @param vo
	 */
	@RequestMapping("addNews")
	public void addNews(News vo){
		this.newsservice.addNews(vo);
	}
	/**
	 * 根据id查询新闻
	 * @param nid
	 * @param request
	 */
	@RequestMapping("findNewsById")
	public void findNewsById(int nid,HttpServletRequest request){
		News vo =this.newsservice.findNewsById(nid);
		request.getSession().setAttribute("news", vo);
	}
	/**
	 * 更新新闻
	 * @param vo
	 */
	@RequestMapping("updateNewsById")
	public void updateNewsById(News vo){
		this.newsservice.updateNewsById(vo);
	}
	/**
	 * 
	 * 根据id删除新闻
	 * @param nid
	 */
	@RequestMapping("deleteNewsById")
	public void deleteNewsById(int nid){
		this.newsservice.deleteNews(nid);
	}

	@RequestMapping("deleteNewsByIds")
	public void deleteNewsByIds(int[] nids){
		for (int i = 0; i < nids.length; i++) {
			int nid = nids[i];
			this.newsservice.deleteNews(nid);
		}
	}

	@RequestMapping("uploadFile")
	@ResponseBody
	public Map<String,Object> uploadFile(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		if(!(file.isEmpty())&&file.getSize()!=0){
			//生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//获取文件类型
			String contentType=file.getContentType();
			//获取文件后缀名
			String imageName=contentType.substring(contentType.indexOf("/")+1);
			//设置保存路径
			String path=uuid+"."+imageName;
			String pathRoot = request.getSession().getServletContext().getRealPath("/static/images/");
			File newfile = new File(pathRoot+File.separator+path);
			if(!newfile.exists()){//不存在就创建
				newfile.mkdirs();
			}

			file.transferTo(newfile);
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("code",0);
			map.put("msg", "cc");
			Map<String,String> data=new HashMap<String,String>();
			data.put("src","/static/images/"+path);
			data.put("title", file.getOriginalFilename());
			map.put("data", data);
			return map;
		}else{
			return null;
		}
	} 
	/**
	 * 列出所有的新闻类型
	 * @param request
	 */
	@RequestMapping("listAllNewsType")
	public void listAllNewsType(HttpServletRequest request){
		List<Newstype> AllNewsType = this.ns.listAllNewsType();
		request.getSession().setAttribute("AllNewsType", AllNewsType);
	}
	
	
	
	
}
