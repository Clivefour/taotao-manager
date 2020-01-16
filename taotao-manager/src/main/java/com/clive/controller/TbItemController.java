package com.clive.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.clive.bean.TbItem;
import com.clive.bean.TbItemDesc;
import com.clive.common.Data;
import com.clive.common.FtpUtil;
import com.clive.common.IDUtils;
import com.clive.common.LayuiTableResult;
import com.clive.common.LayuiUploadResult;
import com.clive.common.TaotaoResult;
import com.clive.constant.Constant;
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
	 * 文件图片接口 ，吧图片上传到图片服务器上面去 不写入到mysql数据库中
	 * @param file 需要上传的文件名称
	 * @return 返回layui上传图片的指定接口json格式
	 */
	@RequestMapping("/fileUpload")
	@ResponseBody
	public LayuiUploadResult fileUpload(MultipartFile file) {
		try {
			Date date = new Date();
			//每天上传的图片 都按照每天的文件夹分好
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			//图片路径
			String filePath = format.format(date);
			//得到需要上传的图片名称
			String fileName = file.getOriginalFilename();
			//通过 springmvc的MultipartFile参数 来得到 图片上传的io流 吧他做为参数传入到 我们封装好的方法里面去
			InputStream input = file.getInputStream();
			
			// 不管页面传递过来的图片 名字叫做什么 比如叫做abc.jpg aaaaa.png 我只要 （随机数生成的图片名称）.png
			fileName = IDUtils.genImageName() + fileName.substring(fileName.lastIndexOf("."));;
			FtpUtil.uploadFile(Constant.FTP_ADDRESS, Constant.FTP_PORT, Constant.FTP_USERNAME, Constant.FTP_PASSWORD,
					Constant.FILI_UPLOAD_PATH, filePath, fileName, input);
			LayuiUploadResult result = new LayuiUploadResult();
			result.setCode(0);
			result.setMsg("");
			Data data = new Data();
			data.setSrc(Constant.IMAGE_BASE_URL+"/"+filePath+"/"+fileName);
			result.setData(data);
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/addItem")
	@ResponseBody
	public TaotaoResult addItem(TbItem item,String itemDesc){
		TaotaoResult result = null;
		return result;
	}
}
