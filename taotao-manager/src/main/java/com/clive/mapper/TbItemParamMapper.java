package com.clive.mapper;

import java.util.List;

import com.clive.bean.TbItemParamGroup;

public interface TbItemParamMapper {
	/**
	 * 根据分类id多表查询规格参数组和每个组对应的规格参数项
	 * @param cId 分类id
	 * @return 规格参数组和每一项对应的值
	 */
	List<TbItemParamGroup> findTbItemGroupByCid(Long cId);

}
