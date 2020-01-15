package com.clive.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbItem;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;
import com.clive.mapper.TbItemMapper;
import com.clive.service.TbItemService;
@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem findTbItemById(Long tbItemId) {
		TbItem tbItem = tbItemMapper.findTbItemById(tbItemId);
		return tbItem;
	}

	@Override
	public LayuiTableResult findItemByPage(Integer page, Integer limit) {
		LayuiTableResult result = new LayuiTableResult();
		result.setCode(0);
		result.setMsg("");
		int count = tbItemMapper.findTbItemCount();
		result.setCount(count);
		//分页的集合对象
		List<TbItem> data = tbItemMapper.findTbItemByPage((page-1)*limit, limit);
		result.setData(data);
		return result;
	}



	@Override
	public TaotaoResult updateItems(List<TbItem> items, Integer type,Date date) {
		List<Long> ids = new ArrayList<Long>();
		for (TbItem tbItem : items) {
			ids.add(tbItem.getId());
		}
		int count = tbItemMapper.updateItemByIds(ids, type,date);
		if(count>0&&type==0){
			return TaotaoResult.build(200, "商品下架成功");
		}else if(count>0&&type==1){
			return TaotaoResult.build(200, "商品上架成功");
		}else if(count>0&&type==2){
			return TaotaoResult.build(200, "商品删除成功");
		}
		return TaotaoResult.build(500, "操作有误");
	}

	@Override
	public LayuiTableResult searchItems(Integer page, Integer limit, String title, Integer priceMin, Integer priceMax,
			Long cId) {
		//在java中判断 我们是在内存中判断 没有在sql语句中判断 这样性能高一点
		if(priceMin==null){
			priceMin = 0;
		}
		if(priceMax==null){
			priceMax = 10000000; 
		}
		LayuiTableResult result = new LayuiTableResult();
		result.setCode(0);
		
		int count = tbItemMapper.findTbItemCountBySearch(title,priceMin,priceMax,cId);
		if(count<=0){
			result.setMsg("没有商品信息");
			return result;
		}
		result.setMsg("");
		result.setCount(count);
		List<TbItem> data = tbItemMapper.findTbItemBySearchPage((page-1)*limit, limit,title,priceMin,priceMax,cId);
		/**
		 * 因为查询条件确定不了 所以 我们的总记录条数 包括 根据条件查询的商品信息 也确定不了
		 */
		result.setData(data);
		return result;
	}
}
