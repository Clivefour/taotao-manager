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
	/**
	 * 根据商品id查询商品信息
	 * @param itemId 商品ID
	 * @return 商品对象的json格式
	 */
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem findTbItemById(@PathVariable Long itemId){
		TbItem tbItem = tbItemService.findTbItemById(itemId);
		return tbItem;
	}
	/**
	 * 返回layui表的json格式数据
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return layui需要的json格式数据
	 */
	@RequestMapping("/showItemPage")
	@ResponseBody
	public LayuiTableResult findTbItemByPage(Integer page,Integer limit){
		LayuiTableResult result = tbItemService.findItemByPage(page, limit);
		return result;
	}
	/**
	 * 根据商品ID删除商品信息 也可以做批量删除
	 * @param items 需要删除的商品集合对象 json格式
	 * @return 提示删除是否成功或者失败的 json格式
	 */
	@RequestMapping("/itemDelete")
	@ResponseBody
	public TaotaoResult deleteItemById(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items, 2,date);
		return result;
	}
	/**
	 * 商品上架接口
	 * @param items 需要上架的商品集合对象 json格式
	 * @return 提示上架是否成功或者失败的 json格式
	 */
	@RequestMapping("/commodityUpperShelves")
	@ResponseBody
	public TaotaoResult commodityUpperShelves(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items,1,date);
		return result;
	}
	/**
	 * 商品下架接口
	 * @param items 需要下架的商品集合对象 json格式
	 * @return 提示下架是否成功或者失败的 json格式
	 */
	@RequestMapping("/commodityLowerShelves")
	@ResponseBody
	public TaotaoResult commodityLowerShelves(@RequestBody List<TbItem> items){
		Date date = new Date();
		TaotaoResult result = tbItemService.updateItems(items,0,date);
		System.out.println(result);
		return result;
	}
	/**
	 * 多条件搜索商品
	 * @param page 当前页
	 * @param limit 每一页显示的条数
	 * @param title 商品标题
	 * @param priceMin 商品金额 最小金额
	 * @param priceMax 商品金额 最大金额
	 * @param cId 商品分类id
	 * @return layui表中规定的数据
	 */
	@RequestMapping("/searchItem")
	@ResponseBody
	public LayuiTableResult searchItem(Integer page,Integer limit,String title,Integer priceMin,Integer priceMax,Long cId){
		LayuiTableResult result = tbItemService.searchItems(page,limit,title,priceMin,priceMax,cId);
		return result;
	}
	/**
	 * 文件上传接口
	 * @param file 需要上传的文件名称
	 * @return
	 */
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
