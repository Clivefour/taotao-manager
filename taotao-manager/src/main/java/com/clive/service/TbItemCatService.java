package com.clive.service;

import java.util.List;

import com.clive.common.ZTreeNodeResult;

public interface TbItemCatService {
	/**
	 * 根据页面传递过来的id 查询商品分类信息 并且默认按照一级分类展示
	 * @param parentId 商品分类id
	 * @return 返回ZTree节点数据 id name isParent
	 */
	List<ZTreeNodeResult> findTbItemCatById(Long parentId);

}
