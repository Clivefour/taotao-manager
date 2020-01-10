package com.clive.mapper;

import java.util.List;

import com.clive.bean.TbItemCat;

public interface TbItemCatMapper {
	/**
	 * 根据parentid 查询商品分类信息
	 * @param parentId 商品分类信息parentid 或者是 页面传递过来的id
	 * @return 商品分类信息集合对象
	 */
	List<TbItemCat> findTbItemCatById(Long parentId);

}
