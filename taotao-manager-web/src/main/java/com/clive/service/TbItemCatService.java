package com.clive.service;

import com.clive.common.ItemCatResult;

public interface TbItemCatService {
	/**
	 * 根据分类id查询该分类下的所有二级类目 以及每个二级类目对应的三级类目
	 * @param id 分类id
	 * @return web程序员要求的json格式数据
	 */
	ItemCatResult getItemCats(long id);

}
