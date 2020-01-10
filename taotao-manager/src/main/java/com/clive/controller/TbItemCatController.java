package com.clive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clive.common.ZTreeNodeResult;
import com.clive.service.TbItemCatService;

@Controller
@RequestMapping("/itemCat")
public class TbItemCatController {
	@Autowired
	private TbItemCatService tbItemCatService;
	
	
	@RequestMapping("/showZtree")
	@ResponseBody
	public List<ZTreeNodeResult> showZTreeNode(@RequestParam(value="id", defaultValue="0")Long parentId){
		/**
		 * @RequestParam注解用于指定 页面传递过来的参数名称 
		 * 页面传递过来id defaultValue如果页面传递过来的参数名字为id的 没有初始值 默认初始值为 0
		 */
		List<ZTreeNodeResult> result = tbItemCatService.findTbItemCatById(parentId);
		return result;
	}
	
}
