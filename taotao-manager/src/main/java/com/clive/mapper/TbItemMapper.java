package com.clive.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbItem;

public interface TbItemMapper {
	/**
	 * 查询数据库中tbitem表，根据商品id查询商品信息
	 * @param tbItemId
	 * @return
	 */
	TbItem findTbItemById(Long tbItemId);
	/**
	 * 查询商品表总记录条数
	 * @return 商品表总记录条数
	 */
	int findTbItemCount();
	/**
	 * 分页显示商品信息
	 * @param index 当前索引
	 * @param pageSize 每一页显示的条数
	 * @return 分页的商品信息集合对象
	 * index外界传进来的参数 名字叫做index
	 */
	List<TbItem> findTbItemByPage(@Param("index") Integer index,@Param("pageSize") Integer pageSize);
	/**
	 * 根据商品id删除商品信息 
	 * @param items
	 * @return 如果返回的数据大于0表示删除成功
	
		int delteItemByIds(@Param("ids") List<Long> ids);
	 */
	int updateItemByIds(@Param("ids") List<Long> ids,@Param("type") Integer type,@Param("date") Date date);
}
