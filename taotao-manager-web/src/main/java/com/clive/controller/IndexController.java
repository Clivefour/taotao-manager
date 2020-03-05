package com.clive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clive.common.ItemCat;
import com.clive.common.ItemCatResult;
import com.clive.common.JsonUtils;
import com.clive.service.TbItemCatService;

@Controller
public class IndexController {
	@Autowired
	private TbItemCatService tbItemCatService;
	
	
	@RequestMapping("/index")
	public String showIndex(){
		/**
		 * 查询数据库 得到url 得到宽高
		 * 然后组装成为web程序员 需要的 数据
		 *  变成json格式 发送到页面
		 *  然后web程序员解析json格式数据 绑定数据 和java程序员没有关系了
		 */
		
		return "index";
	}
	@RequestMapping("/itemcat/all")
	@ResponseBody
	public String getItemCats(){
		//这个对象 是我想要返回给页面的json格式的字符串
		ItemCatResult result = tbItemCatService.getItemCats(0L);
		/**
		 * spring返回类型配合@ResponseBody注解以后
		 * 返回什么字符串 他就不会跳转页面 吧这个字符串 输出到页面上面
		 * 那么我的想法是 吧这个对象 自己改变json格式的字符串 返回到页面就行了
		 * jackson帮我们做好了的
		 */
		String json = JsonUtils.objectToJson(result);
		
		return json;
	}
}
