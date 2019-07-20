package com.tjetc.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjetc.pojo.Profile;

@Controller
@RequestMapping("/client")
public class ProfileController {
	@RequestMapping("/profile")
	public String profile(Profile p,HttpServletResponse response,Model model){
		p.setId(1);
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/main/resources/db.properties"), "utf-8");
			osw.write("jdbc.driver=com.mysql.jdbc.Driver"+"\r\n");
			osw.write("jdbc.url=jdbc:mysql://"+p.getDriver()+"/"+p.getUrl()+"?characterEncoding=utf-8"+"\r\n");
			osw.write("jdbc.username="+p.getName()+"\r\n");
			osw.write("jdbc.password="+p.getPassword());
			osw.flush();
			osw.close();
			//回显配置文件信息.
			model.addAttribute("p", p);		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return "true";
	}

	@RequestMapping("/proshow")
	public String proshow(Profile p,Model model) {
		
		StringBuffer sb=new StringBuffer();
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader("src/main/resources/db.properties"));
			String s="";
			s = br.readLine(); // 读取第一行 
			if (s != null) { // 如果 line 为空说明读完了 
				sb.append(s); // 将读到的内容添加到 buffer 中 
				sb.append("\n"); // 添加换行符 
			}
			s = br.readLine(); // 读取下一行 
			if(s != null){
				sb.append(s);
				int index=s.indexOf("/");
				
				int index2=s.indexOf("?");
				int index3=s.indexOf("/",index+2);
				String result=s.substring(index3+1,index2);
				
				p.setUrl(result);
				String re=s.substring(index+2,index3);
				p.setDriver(re);
				sb.append("\n");
			}
			s = br.readLine(); // 读取下一行 
			if(s != null){
				sb.append(s);
				int index=s.indexOf("=");
				String result=s.substring(index+1);
				p.setName(result);
				sb.append("\n");				
			}
			s = br.readLine(); // 读取下一行 
			if(s != null){
				sb.append(s);
				int index=s.indexOf("=");
				String result=s.substring(index+1);
				
				p.setPassword(result);
				sb.append("\n");			
			}	

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("p", p);	
		return "datasource/profile";

	}

}
