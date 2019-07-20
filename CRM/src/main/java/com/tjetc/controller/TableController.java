package com.tjetc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.CusLost;
import com.tjetc.pojo.CustomerAnalyze;
import com.tjetc.service.impl.TableService;

@Controller
@RequestMapping("/tab")
public class TableController {
@Autowired
private TableService tableService;
@RequestMapping("/listrank")
@ResponseBody
public List<CustomerAnalyze> listrank(HttpServletResponse response){
	
	  List<CustomerAnalyze> list = tableService.listrank();
	return list;
}
@RequestMapping("/listCre")
@ResponseBody
public List<CustomerAnalyze> listCre(){
	
	  List<CustomerAnalyze> list = tableService.listCre();
	 
	return list;
}
@RequestMapping("/listSati")
@ResponseBody
public List<CustomerAnalyze> listSati(){
	List<CustomerAnalyze> list = tableService.listSati();
	for (CustomerAnalyze customerAnalyze : list) {
		System.out.println(customerAnalyze);
	}
	return list;
}
@RequestMapping("/listrank2")
@ResponseBody
public HashMap<String, Object> listrank2(){
	//等级和等级下订单数量
	List<CustomerAnalyze> list = tableService.list();
	//客户和订单数量
	List<CustomerAnalyze> list2 = tableService.list2();
	
	HashMap<String, Object> map = new HashMap<>();
	map.put("list", list);
	map.put("list2", list2);
	return map;
}
//
@RequestMapping("/getTableOne")
@ResponseBody
public int[] getTableOne(Model model){
	System.out.println("--------进入controler...");
	//找各个原因对应的数量
	int c1=tableService.getcount1();
	int c2=tableService.getcount2();
	int c3=tableService.getcount3();
	int c4=tableService.getcount4();
	System.out.println("从数据库取出的数量："+c1+"--"+c2+"--"+c3+"--"+c4);
	int[] array=new int[]{c1,c2,c3,c4};
	return array;
}
@RequestMapping("/getTabletwo")
@ResponseBody
public int[][] getTabletwo(Model model){
	System.out.println("--------进入controler的two方法...");
	int r11=tableService.selectByYear11();
	System.out.println("r11:"+r11);
	int r12=tableService.selectByYear12();
	System.out.println("r12:"+r12);
	int r13=tableService.selectByYear13();
	System.out.println("原因一："+r11+","+r12+","+r13);
	int r21=tableService.selectByYear21();
	int r22=tableService.selectByYear22();
	int r23=tableService.selectByYear23();
	System.out.println("原因二："+r21+","+r22+","+r23);
	int r31=tableService.selectByYear31();
	int r32=tableService.selectByYear32();
	int r33=tableService.selectByYear33();
	System.out.println("原因三："+r31+","+r32+","+r33);
	int r41=tableService.selectByYear41();
	int r42=tableService.selectByYear42();
	int r43=tableService.selectByYear43();
	System.out.println("原因四："+r41+","+r42+","+r43);
	//放进二维数组中
	/*int[][] arr=new int[3][4];*/
	int[][] arrYear={{r13,r12,r11},{r23,r22,r21},{r33,r32,r31},{r43,r42,r41}};
	return arrYear;
}
@RequestMapping("/query")
public String query(Model model,String cname,String cmname,CusLost cusLost){
	System.out.println("--------进入controler的多条件查询..."+cname+","+cmname);
	List<CusLost> list=tableService.list(cusLost);
	for (CusLost cusLost2 : list) {
		System.out.println("在controler得到流失原因表list:"+cusLost2);
	}
	model.addAttribute("tableList", list);
	model.addAttribute("cname", cname);
	model.addAttribute("cmname", cmname);
	return "Count-table/table_userlost";
}
}
