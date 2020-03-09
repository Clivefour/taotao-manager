package com.clive.service;

import java.util.List;

import com.clive.bean.TbContent;

public interface TbContentService {
	/**
	 * 根据内容分类id 查询内容信息
	 * @param categoryId 内容分类id
	 * @return 指定内容分类的 内容集合信息
	 */
	List<TbContent> findContents(long categoryId);

}
