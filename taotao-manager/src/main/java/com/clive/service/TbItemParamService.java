package com.clive.service;

import com.clive.common.TaotaoResult;

public interface TbItemParamService {
	/**
	 * 根据分类id查询规格参数组合每一个组对应的规格参数项并且把数据
	 * 封装到TaotaoResult里面 返回给页面
	 * @param cId 分类id
	 * @return 里面包含了规格参数组合规格参数项数据 以及 状态码200 和 描述消息 msg
	 */
	TaotaoResult findTbItemGroupByCId(Long cId);

}
