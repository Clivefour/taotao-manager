package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbItemCat;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbItemCatMapper;
import com.clive.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
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

}
