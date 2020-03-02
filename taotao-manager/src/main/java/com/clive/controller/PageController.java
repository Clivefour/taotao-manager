package com.clive.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

@Controller
public class PageController {
	/**
	 * 首页跳转controller
	 * @return 首页
	 * 我们之所以 能够输入http://localhost:8080/这个地址就访问到首页 由一下几个原因
	 * 1.我们pom.xml里面配置了 项目的访问路径为 / 所以 我们的项目初始路径为
	 * http://localhost:8080/然后呢  我们请求/这个路径的时候 通过springmvc返回
	 * String类型 让他跳转到index页面 但是呢 跳转页面的时候  会拼接前缀和后缀
	 */

	@RequestMapping("/")
	public String showIndex(){
		
		return "index";
	}
	
	
	
}
