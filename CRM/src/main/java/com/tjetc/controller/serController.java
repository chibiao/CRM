package com.tjetc.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.SerCj;
import com.tjetc.pojo.SerCl;
import com.tjetc.pojo.SerResult;
import com.tjetc.pojo.SerType;
import com.tjetc.service.impl.serService;

@Controller
@RequestMapping("/service")
public class serController {
	@Autowired
	private serService serservice;
	@RequestMapping("/listGuidang")
	public String listGuidang(HttpServletRequest request){
		 String custom = request.getParameter("custom");
		   custom=custom==null?"":custom;
			String id = request.getParameter("id");
			id=id==null?"":id;
			String types = request.getParameter("types");
			int type=(types==null||types.equals(""))?0:Integer.parseInt(types);
			String curPage = request.getParameter("curPage");
			int currentPage=curPage==null?1:Integer.parseInt(curPage);
			int pageSize=5;
			Map<String, Object> map= serservice.getMapGui(custom,id,type,currentPage,pageSize);
			
			request.setAttribute("teaList1", map.get("teaList1"));
			request.setAttribute("page", map.get("page"));
			request.setAttribute("custom",custom);
			request.setAttribute("id", id);
			request.setAttribute("types", type==0?"":type);
		   
		   //遍历服务类型
		   List<SerType> listType =serservice.listType();
		  request.setAttribute("listType",listType);
		   return "serverManage/serviceGuidang";
	}
	@RequestMapping("/save")
	public String save(HttpServletRequest request){
		String id = request.getParameter("id");
		String result = request.getParameter("result");
		String satisfied = request.getParameter("satisfied");
		satisfied = satisfied==null?"1":satisfied;
		if (Integer.parseInt(satisfied)>=3) {
			serservice.updateGui(id);
		}else if(Integer.parseInt(satisfied)<3){
			serservice.updateFen(id);
		}
		SerResult serResultAdd = new SerResult(id, result, Integer.parseInt(satisfied));
		SerResult serResult = serservice.getResult(id);
		System.out.println(serResult+"--根据id查询是否为空");
		if (serResult==null||serResult.equals("")) {
			serservice.addRes(serResultAdd);
		}else {
			serservice.updateRes(serResultAdd);
		}
		
		return "redirect:list";
	}
	@RequestMapping("/daochu")
	@ResponseBody
	public void daochu(HttpServletResponse response){
        //1.从数据库取出数据
        List<SerCj> cj = serservice.listCj();
        System.out.println(cj);
        List<SerType> type = serservice.listType();
        //2.创建excel
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("员工数据");
        //创建一行
        HSSFRow row = sheet.createRow(0);
        //创建一列
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("客户");
        row.createCell(2).setCellValue("概要");
        row.createCell(3).setCellValue("服务类型");
        row.createCell(4).setCellValue("处理人");
        row.createCell(5).setCellValue("处理日期");
        /*取出每一个员工设置数据*/
        HSSFRow cjRow;
        for (int i = 0; i < cj.size(); i++) {
            SerCj sercj = cj.get(i);
            cjRow = sheet.createRow(i + 1);
            
            String id = sercj.getId()==null||sercj.getId().equals("")?"数据为空":sercj.getId();
            SerCl scl = new SerCl(id,"数据为空","数据为空","数据为空");
            String custom = sercj.getCustom()==null||sercj.getCustom().equals("")?"数据为空":sercj.getCustom();
            String description = sercj.getDescription()==null||sercj.getDescription().equals("")?"数据为空":sercj.getDescription();
            SerCl sercl = sercj.getSercl()==null||sercj.getSercl().equals("")?scl:sercj.getSercl();
            String clname = sercl.getClname()==null||sercl.getClname().equals("")?"数据为空":sercl.getClname();
            String cltime = sercl.getCltime()==null||sercl.getCltime().equals("")?"数据为空":sercl.getCltime();
            cjRow.createCell(0).setCellValue(id);
            cjRow.createCell(1).setCellValue(custom);
            cjRow.createCell(2).setCellValue(description);
            for (SerType sertype : type) {
            	String m = sertype.getId()==null?"1":sertype.getId();
            	if (sercj.getTypes()==Integer.parseInt(m)) {
            		cjRow.createCell(3).setCellValue(sertype.getTname());
    			}
			}

            cjRow.createCell(4).setCellValue(clname);
            cjRow.createCell(5).setCellValue(cltime);
        }
        //3.响应给浏览器
        try {
            String fileName = new String("归档档案.xls".getBytes(), "iso8859-1");
            response.setHeader("content-Disposition", "attachment;filename=" + fileName);
            wb.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@RequestMapping("/getById")
	public String getById(Model model,String id){
		SerCj sercj = serservice.getById(id);
		List<SerType> listType = serservice.listType();
		model.addAttribute("listType", listType);
		model.addAttribute("sercj", sercj);
		return "serverManage/serviceFankuiUpdate";
	}
	@RequestMapping("/getByIdGui")
	public String getByIdGui(Model model,String id){
		SerCj sercj = serservice.getByIdGui(id);
		System.out.println(sercj+"---归档");
		List<SerType> listType = serservice.listType();
		model.addAttribute("listType", listType);
		model.addAttribute("sercj", sercj);
		return "serverManage/serviceGuidangUp";
	}
	@RequestMapping("/list")
	   public String show( Model model,HttpServletRequest request){
		/*List<SerCj> listCj = serservice.listCj();
		model.addAttribute("listCj", listCj);*/
		   String custom = request.getParameter("custom");
		   custom=custom==null?"":custom;
			String id = request.getParameter("id");
			id=id==null?"":id;
			String types = request.getParameter("types");
			int type=(types==null||types.equals(""))?0:Integer.parseInt(types);
			String curPage = request.getParameter("curPage");
			int currentPage=curPage==null?1:Integer.parseInt(curPage);
			int pageSize=5;
			Map<String, Object> map= serservice.getMap(custom,id,type,currentPage,pageSize);
			
			request.setAttribute("teaList1", map.get("teaList1"));
			request.setAttribute("page", map.get("page"));
			request.setAttribute("custom",custom);
			request.setAttribute("id", id);
			request.setAttribute("types", type==0?"":type);
		   
		   //遍历服务类型
		   List<SerType> listType =serservice.listType();
		   //model.addAttribute("listType",listType);
		  request.setAttribute("listType",listType);
		   return "serverManage/serviceFankui";
	   }
}
