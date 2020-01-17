package com.clive.mapper;

import com.clive.bean.TbItemDesc;

public interface TbItemDescMapper {
	/**
	 * 添加商品描述信息
	 * @param tbItemDesc 商品描述信息对象
	 * @return 返回一个整数 如果数字大于0则表示添加成功
	 */
	int saveTbItemDesc(TbItemDesc tbItemDesc);

}
