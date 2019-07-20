package com.tjetc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		System.out.println("1111111");
		return "main";
	}

	@RequestMapping("/second")
	public String second() {
		return "second";
	}
}
