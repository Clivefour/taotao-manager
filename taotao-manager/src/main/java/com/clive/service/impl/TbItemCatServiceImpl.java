package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clive.bean.TbItem;
import com.clive.bean.TbItemCat;
import com.clive.common.EchartsResult;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbItemCatMapper;
import com.clive.mapper.TbItemMapper;
import com.clive.service.TbItemCatService;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	private String name;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public List<ZTreeNodeResult> findTbItemCatById(Long parentId) {
		List<TbItemCat> tbItemCats = tbItemCatMapper.findTbItemCatById(parentId);
		List<ZTreeNodeResult> result = new ArrayList<ZTreeNodeResult>();
		for (TbItemCat tbItemCat : tbItemCats) {
			ZTreeNodeResult node = new ZTreeNodeResult();
			node.setId(tbItemCat.getId());
			node.setName(tbItemCat.getName());
			node.setIsParent(tbItemCat.getIsParent());
			result.add(node);
		}
		return result;
	}

	@Override
	public List<EchartsResult> statisticsItem() {
		List<EchartsResult> results = new ArrayList<EchartsResult>();
		List<TbItem> tbItems = tbItemMapper.statisticsItemCId();
		for (TbItem tbItem : tbItems) {
			EchartsResult result = new EchartsResult();
			TbItemCat tbItemCat = tbItemCatMapper.getTbItemCatById(tbItem.getcId());
			getFirstItemCat(tbItemCat);
			result.setName(name+"类");
			int value = tbItemMapper.findTbItemCountByCId(tbItem.getcId());
			result.setValue(value);
			results.add(result);
		}
		return results;
	}
	
	/**
	 * 根据分类的父级ID查询分类父级对象 最终是查询得到 一级类目的名称
	 * @param tbItemCat
	 * @return null 
	 */
	private String getFirstItemCat(TbItemCat tbItemCat) {
		TbItemCat cat = tbItemCatMapper.getTbItemCatById(tbItemCat.getParentId());
		if(cat!=null){
			name = cat.getName();
			getFirstItemCat(cat);
		}
		return null;
	}
	
}
