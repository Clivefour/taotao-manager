package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbContentCategory;
import com.clive.bean.TbItemCat;
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

}
