package com.clive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clive.common.EchartsResult;
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
	@RequestMapping("/statisticsItem")
	@ResponseBody 
	public List<EchartsResult> showEcharts(){
		List<EchartsResult> results = new ArrayList<EchartsResult>();
		EchartsResult echarts1 = new EchartsResult();
		echarts1.setName("手机类");
		echarts1.setValue(1000);
		EchartsResult echarts2 = new EchartsResult();
		echarts2.setName("电脑类");
		echarts2.setValue(1500);
		EchartsResult echarts3 = new EchartsResult();
		echarts3.setName("服装类");
		echarts3.setValue(5005);
		results.add(echarts1);
		results.add(echarts2);
		results.add(echarts3);
		return results;
	}
	
}
