package com.clive.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.clive.bean.TbItem;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;
import com.clive.service.TbItemService;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	private TbItemService tbItemService;
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem findTbItemById(@PathVariable Long itemId){
		TbItem tbItem = tbItemService.findTbItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/showItemPage")
	@ResponseBody
	public LayuiTableResult findTbItemByPage(Integer page,Integer limit){
		LayuiTableResult result = tbItemService.findItemByPage(page, limit);
		return result;
	}
	@RequestMapping("/itemDelete")
	@ResponseBody
	public TaotaoResult deleteItemById(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items, 2,date);
		return result;
	}
	@RequestMapping("/commodityUpperShelves")
	@ResponseBody
	public TaotaoResult commodityUpperShelves(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items,1,date);
		return result;
	}
	@RequestMapping("/commodityLowerShelves")
	@ResponseBody
	public TaotaoResult commodityLowerShelves(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items,0,date);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/searchItem")
	@ResponseBody
	public LayuiTableResult searchItem(Integer page,Integer limit,String title,Integer priceMin,Integer priceMax,Long cId){
		LayuiTableResult result = tbItemService.searchItems(page,limit,title,priceMin,priceMax,cId);
		return result;
	}
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(MultipartFile file){
		//在这里面 我们是进行吧图片存入图片服务器 并且把图片服务器的路径返回给页面
		System.out.println(file.getOriginalFilename());
		//我们发回给页面的不是 ok 老铁 我们发回去的应该是 图片的路径
		return "ok";
	}
	@RequestMapping("/addItem")
	@ResponseBody
	public String addItem(String content){
		System.out.println(content);
		return "ok";
	}
}
