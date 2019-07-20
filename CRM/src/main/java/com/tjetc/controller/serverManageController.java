package com.tjetc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerCl;
import com.tjetc.pojo.SerFp;
import com.tjetc.pojo.SerType;
import com.tjetc.pojo.User;
import com.tjetc.service.impl.SerCjService;
import com.tjetc.service.impl.SerClService;
import com.tjetc.service.impl.SerFpService;
import com.tjetc.service.impl.SerTypeService;

@Controller
@RequestMapping("/sercj")
public class serverManageController {
   @Autowired
   private SerCjService cjService =new SerCjService();
   @Autowired
   private SerTypeService serTypeService=new SerTypeService();
   @Autowired
   private SerFpService serFpService=new SerFpService();
   @Autowired
   private SerClService serClService=new SerClService();
   @RequestMapping("/save")
   public String save(SerCj sercj,HttpServletRequest request){
	   //自动生成时间
	   request.setAttribute("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	   //生成UUID
	   String id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	   request.setAttribute("uid", id);
	   List<SerType> listType =serTypeService.listType();
	   System.out.println(listType);
	   //model.addAttribute("listType",listType);
	  request.setAttribute("listType",listType);
	   return "serverManage/newService";
	   
   }
   @RequestMapping("/add")
   public String add(SerCj sercj,HttpServletRequest request){
	   String id = request.getParameter("id");
	   System.out.println(id);
	   String types = request.getParameter("types");
	   System.out.println(types);
	   String description = request.getParameter("description");
	   System.out.println(description);
	   String custom = request.getParameter("custom");
	  
	   String req = request.getParameter("req");
	   System.out.println(req);
	   String cname = request.getParameter("cname");
	   String ctime = request.getParameter("ctime");
	   SerCj serCj = new SerCj(id, Integer.parseInt(types), description, custom, 0, cname, ctime, req);
	   System.out.println(serCj);
	   cjService.add(serCj);
	   
	   return "redirect:/sercj/save";
	   
   }
   @RequestMapping("/list")
   public String show( HttpServletRequest request){
	   String custom = request.getParameter("custom");
	   custom=custom==null?"":custom;
		String id = request.getParameter("id");
		id=id==null?"":id;
		String types = request.getParameter("types");
		System.out.println(types);
		int type=(types==null||types.equals(""))?0:Integer.parseInt(types);
		String curPage = request.getParameter("curPage");
		int currentPage=curPage==null?1:Integer.parseInt(curPage);
		int pageSize=5;
		Map<String, Object> map= cjService.getMap(custom,id,type,currentPage,pageSize);
		
		request.setAttribute("teaList1", map.get("teaList1"));
		request.setAttribute("page", map.get("page"));
		request.setAttribute("custom",custom);
		request.setAttribute("id", id);
		request.setAttribute("types", type==0?"":type);
		System.out.println(map.get("teaList1"));
	   /*//遍历整个列表
	   List<SerCj> listSerCj=cjService.listSerCj();
	   request.setAttribute("listCj", listSerCj);*/
	   
	   //遍历服务类型
	   List<SerType> listType =serTypeService.listType();
	   System.out.println(listType);
	   //model.addAttribute("listType",listType);
	  request.setAttribute("listType",listType);
	   return "serverManage/serviceFenPei";
   }
   @RequestMapping("/getById")
   public String getById(HttpServletRequest request){
	 //自动生成时间
	   request.setAttribute("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));		   
	   	
	   	String id = request.getParameter("id");
	   	List<User> getIdRole = cjService.getIdRole();
		SerCj sercj=cjService.getById(id);
		request.setAttribute("fenlist", getIdRole);
		request.setAttribute("sercj", sercj);
		 return "serverManage/serviceFenPeiUpdate";
   }
@RequestMapping("/update")
 public String update(HttpServletRequest request){
	   String id = request.getParameter("id");
	   cjService.update(id);
	   String fname = request.getParameter("fname");
	   String cname = request.getParameter("cname");
	   String ftime = request.getParameter("ctime");
	   //SerCj serCj = new SerCj(id, Integer.parseInt(types), description, custom, 0, cname, ctime, req);
	   //System.out.println(serCj);
	   SerFp serfp=new SerFp(id,cname, ftime, fname);
	   SerFp fp = serFpService.getFp(id);
	   if (fp==null) {
		   serFpService.add(serfp);
		}else{
			 serFpService.updateFp(serfp);
		}
	   
//	   return "redirect:/sercj/fplist";
	   return "redirect:list";
	   
 }
@RequestMapping("/fplist")
public String fplist(HttpServletRequest request){
	String custom = request.getParameter("custom");
	   custom= custom==null?"":custom;
		String id = request.getParameter("id");
		id=id==null?"":id;
		String types = request.getParameter("types");
		System.out.println(types);
		int type=(types==null||types.equals(""))?0:Integer.parseInt(types);
		String curPage = request.getParameter("curPage");
		int currentPage=curPage==null?1:Integer.parseInt(curPage);
		int pageSize=5;
		Map<String, Object> map= serFpService.getMap(custom,id,type,currentPage,pageSize);
		System.out.println(map.get("teaList1"));
		request.setAttribute("teaList1", map.get("teaList1"));
		request.setAttribute("page", map.get("page"));
		request.setAttribute("custom",custom);
		request.setAttribute("id", id);
		request.setAttribute("types", type==0?"":type);
		System.out.println(map.get("teaList1")+"---------");
	   /*//遍历整个列表
	   List<SerCj> listSerCj=cjService.listSerCj();
	   request.setAttribute("listCj", listSerCj);*/
	   
	   //遍历服务类型
	   List<SerType> listType =serTypeService.listType();
	   System.out.println(listType);
	   //model.addAttribute("listType",listType);
	  request.setAttribute("listType",listType);
	   
	   return "serverManage/serviceFenPeiList";
	   
}

@RequestMapping("/getChuLiById")
public String getChuLiById(HttpServletRequest request){
	   String id = request.getParameter("id");
	   SerCj cj = cjService.getByIdChuli(id);
	   System.out.println(cj+"************************");
	 //自动生成时间
	   request.setAttribute("cltime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));		   
	   request.setAttribute("sercj", cj);
	   return "serverManage/serviceChuLi";
}

@RequestMapping("/updateChuLi")
public String updateChuLi(HttpServletRequest request){
	 String id = request.getParameter("id");
	   cjService.updateChuLi(id);
	   String clname = request.getParameter("clname");
	   String handle = request.getParameter("handle");
	   String cltime = request.getParameter("cltime");
	   //SerCj serCj = new SerCj(id, Integer.parseInt(types), description, custom, 0, cname, ctime, req);
	   //System.out.println(serCj);
	   SerCl sercl=new SerCl(id, clname, cltime, handle);
	   SerCl cl = serClService.getCl(id);
	   if (cl==null) {
		   serClService.add(sercl);
		}else{
			 serClService.updateCl(sercl);
		}
	   
	   return "redirect:fplist";
}
}
