package com.tjetc.controller;

import java.io.File;
import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tjetc.pojo.Websystem;
import com.tjetc.service.WebsystemService;

@Controller
@RequestMapping("/websystem")
public class WebsystemController{
	@Autowired
	private WebsystemService service;
	 @RequestMapping("/show")
		public String getById(String m,Model model) {
			Websystem ws=service.getById(1);
			model.addAttribute("ws", ws);
			
			if("show".equals(m)){
				return "datasource/systemShow";
			}else if("update".equals(m)){
				return "datasource/systemUpdate";
			}
			return null;
			
		}
	 @RequestMapping("/update")
	
		public String update(Websystem ws,HttpServletRequest request) {
		
			MultipartHttpServletRequest mulrequest=(MultipartHttpServletRequest) request;
			MultipartFile file = mulrequest.getFile("photo");
			if(file!=null && file.getSize()>0){
				
				String realPath = request.getServletContext().getRealPath("/upload/");
				File dir = new File(realPath);
				if(!dir.exists()){
					dir.mkdirs();
				}
				File destfile = new File(dir,file.getOriginalFilename());
				try {
					file.transferTo(destfile);
					ws.setSyslogoip("upload/"+file.getOriginalFilename());
					
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				Websystem ws2 = service.getById(ws.getSysremid());
				ws.setSyslogoip(ws2.getSyslogoip());
			}
			
			service.update(ws);
			return "redirect:../views/datasource/systemIndex.jsp";
		}
	 @RequestMapping("/message")
	 @ResponseBody
		public Websystem message() {
			Websystem ws=service.getById(1);
			return ws;
			
		}
	 
}
