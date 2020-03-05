package com.clive.service;

import java.util.List;

import com.clive.common.ZTreeNodeResult;

public interface TbContentService {
	/**
	 * 根据parentId得到内容分类信息，并且把内容分类信息组装好zTree需要的数据
	 * @param parentId 分类父级类目id
	 * @return zTree需要的结果集
	 */
	List<ZTreeNodeResult> findTbContentById(Long parentId);

}
