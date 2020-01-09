package com.clive.service;

import java.util.Date;
import java.util.List;

import com.clive.bean.TbItem;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;

public interface TbItemService {
	/**
	 * 根据商品id查询商品指定信息
	 * @param tbItemId 商品id
	 * @return 指定商品id的商品信息
	 */
	TbItem findTbItemById(Long tbItemId);
	/**
	 * 分页显示商品信息
	 * @param page 当前页 需要计算索引的
	 * @param limit 每一页显示的条数
	 * @return layui指定的json格式
	 */
	LayuiTableResult findItemByPage(Integer page,Integer limit);
	/**
	 
	 * @param items 需要删除的商品信息集合对象 但是我们只要id
	 * @return 返回TaotaoResult对象
	
	TaotaoResult delteItemByIds(List<TbItem> items);
	 */
	/**
	 * 上架下架和删除方法 但是这个删除 不是真的删除数据 而是 修改商品的状态
	 * @param items 需要上架和下架的商品对象集合 只需要id
	 * @param type 0代表下架 1代表上架  2代表删除
	 * @param date 代表更新时间
	 * @return
	 *  返回TaotaoResult对象 里面有三个属性 status msg data
	 * status:代表 响应的状态码 如果为200则删除成功 否则删除失败 500
	 * msg:代表提示页面的信息 
	 * data:如果页面需要一个json格式的数据 做为操作  那么data里面就是这个对象
	 */
	TaotaoResult updateItems(List<TbItem> items, Integer type,Date date);
	/**
	 * 多条件查询商品信息
	 * @param page 开始索引 一开始为第一页 默认值为1
	 * @param limit 每一页显示的记录条数 默认值为10
	 * @param title 商品名称 如果页面不传入参数默认值为""空字符串
	 * @param priceMin 商品价格区间最低价 如果页面不传入参数默认值为null
	 * @param priceMax 商品价格区间最高价 如果页面不传入参数默认值为null
	 * @param cId 商品分类id 如果页面不传入参数入参数默认值为null
	 * @return layui需要的json格式对象
	 */
	LayuiTableResult searchItems(Integer page, Integer limit, String title, Integer priceMin, Integer priceMax,
			Long cId);
}
