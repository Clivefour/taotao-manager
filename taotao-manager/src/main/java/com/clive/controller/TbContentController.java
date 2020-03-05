package com.clive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
