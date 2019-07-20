package com.tjetc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tjetc.service.importDatasourceService;

@Controller
public class systemDataSourceController {
	@Autowired
	private importDatasourceService service;
	private static  boolean b=false;
	@RequestMapping("/importDataSource")
	public void importDataSource(HttpServletRequest request){
		MultipartHttpServletRequest muilt=(MultipartHttpServletRequest) request;
		MultipartFile file = muilt.getFile("file");
		String filename = file.getOriginalFilename();		
		boolean b = service.autoImport(filename);
	}
	@ResponseBody
	@RequestMapping("/sentTip")
	public String sentTip(){
		if(b){
			return new String("恢复成功！");
		}else{		
			return new String("恢复失败！");
		}
		
	}
}
