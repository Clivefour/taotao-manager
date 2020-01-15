package com.clive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 首页跳转controller
	 * @return 首页
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
}
