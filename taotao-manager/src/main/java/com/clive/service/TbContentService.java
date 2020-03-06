package com.clive.service;

import java.util.List;

import com.clive.common.LayuiTableResult;
import com.clive.common.ZTreeNodeResult;

public interface TbContentService {
	/**
	 * 根据parentId得到内容分类信息，并且把内容分类信息组装好zTree需要的数据
	 * @param parentId 分类父级类目id
	 * @return zTree需要的结果集
	 */
	List<ZTreeNodeResult> findTbContentById(Long parentId);
	/**
	 * 根据内容分类id查询内容信息 
	 * @param categoryId 内容分类id
	 * @param limit 
	 * @param page 
	 * @return layui table表固定的json格式的数据
	 */
	LayuiTableResult findTbContentByCategoryId(Long categoryId, Integer page, Integer limit);

}
