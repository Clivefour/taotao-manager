package com.clive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clive.common.LayuiTableResult;
import com.clive.common.ZTreeNodeResult;
import com.clive.service.TbContentService;

@Controller
@RequestMapping("/content")
public class TbContentController {
	@Autowired
	private TbContentService tbContentService;
	
	@RequestMapping("/showContentZtree")
	@ResponseBody
	public List<ZTreeNodeResult> showContentZtree(@RequestParam(value="id", defaultValue="0")Long parentId){
		List<ZTreeNodeResult> result = tbContentService.findTbContentById(parentId);
		return result;
	}
	
	@RequestMapping("/showContentTable")
	@ResponseBody
	public LayuiTableResult showContentTable(@RequestParam(value="categoryId", defaultValue="0")Long categoryId,Integer page,Integer limit){
		if(categoryId==0){
			return null;
		}
		LayuiTableResult result = tbContentService.findTbContentByCategoryId(categoryId,page,limit);
		return result;
	}
}
