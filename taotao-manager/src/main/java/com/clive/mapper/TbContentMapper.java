package com.clive.mapper;

import java.util.List;

import com.clive.bean.TbContentCategory;

public interface TbContentMapper {
	/**
	 * 根据父级id查询内容分类信息 得到内容分类信息集合对象
	 * @param parentId 内容分类父级id
	 * @return 内容分类信息集合对象
	 */
	List<TbContentCategory> findTbContentByParentId(Long parentId);
	
}
