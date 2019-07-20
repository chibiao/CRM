package com.tjetc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.pojo.CusLost;
import com.tjetc.service.impl.LostService;

@Controller
@RequestMapping("/lost")
public class LostListController {
    @Autowired
    private LostService ls;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(){
    	Map<String, Object> map=ls.list();
    	System.out.println(map);
		return map;
    	
    }
    @RequestMapping("/update")
    @ResponseBody
    public String getById(Model model,int lostid,int laststatus){
    	CusLost lost=new CusLost();
    	lost.setLostid(lostid);
    	lost.setLaststatus(laststatus);
    	ls.update(lost);
    	return "true";
    	
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int lostid){
    	
    	ls.del(lostid);
    	return "true";
    	
    }
}
