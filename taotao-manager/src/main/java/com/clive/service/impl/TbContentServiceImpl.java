package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbContent;
import com.clive.bean.TbContentCategory;
import com.clive.common.LayuiTableResult;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbContentMapper;
import com.clive.service.TbContentService;
@Service
public class TbContentServiceImpl implements TbContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	@Override
	public List<ZTreeNodeResult> findTbContentById(Long parentId) {
		List<TbContentCategory> contentCategorys = tbContentMapper.findTbContentByParentId(parentId);
		List<ZTreeNodeResult> result = new ArrayList<ZTreeNodeResult>();
		for (TbContentCategory category : contentCategorys) {
			ZTreeNodeResult node = new ZTreeNodeResult();
			node.setId(category.getId());
			node.setName(category.getName());
			node.setIsParent(category.getIsParent());
			result.add(node);
		}
		return result;
	}
	@Override
	public LayuiTableResult findTbContentByCategoryId(Long categoryId, Integer page, Integer limit) {
		LayuiTableResult result = new LayuiTableResult();
		result.setCode(0);
		result.setMsg("");
		int count = tbContentMapper.findTbContentCountByCategoryId(categoryId);
		result.setCount(count);
		List<TbContent> data = tbContentMapper.findTbContentByCategoryId(categoryId,(page-1)*limit,limit);
		result.setData(data);
		return result;
	}
	

}
