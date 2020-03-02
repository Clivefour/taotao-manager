package com.clive.mapper;

import java.util.Date;
import java.util.List;

import javax.security.auth.Subject;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbItem;
import com.clive.bean.TbItemCat;

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
	 * 修改商品状态的方法
	 * @param items
	 * @return 如果返回的数据大于0表示删除成功
	
		int delteItemByIds(@Param("ids") List<Long> ids);
	 */
	int updateItemByIds(@Param("ids") List<Long> ids,@Param("type") Integer type,@Param("date") Date date);
	/**
	 * 多条件查询根据商品总数
	 * @param title 商品标题
	 * @param priceMin 商品价格 最低价格
	 * @param priceMax 商品价格 最高价格
	 * @param cId 商品分类id
	 * @return 根据多个条件查询商品总数量 
	 */
	int findTbItemCountBySearch(@Param("title")String title, @Param("priceMin")Integer priceMin, @Param("priceMax")Integer priceMax, @Param("cId")Long cId);
	/**
	 * 多条件查询商品信息并且分页显示
	 * @param index 开始索引 默认值为0
	 * @param limit 每一页显示的条数 默认值为10
	 * @param title 商品名称
	 * @param priceMin 商品最低价格 默认值为0
	 * @param priceMax 商品最高价格 默认值为 100000
	 * @param cId 商品分类id
	 * @return 分页显示的商品信息
	 */
	List<TbItem> findTbItemBySearchPage(@Param("index")int index, @Param("limit")Integer limit, @Param("title")String title, @Param("priceMin")Integer priceMin, @Param("priceMax")Integer priceMax, @Param("cId")Long cId);
	/**
	 * 查询商品表，按照商品分类id按组分类，并且返回商品对象
	 * @return
	 */
	List<TbItem> statisticsItemCId();
	/**
	 * 根据分类id查询商品表中该分类的商品数量
	 * @param getcId
	 * @return
	 */
	int findTbItemCountByCId(@Param("cId")Long cId);
	/**
	 * 添加商品基本信息 
	 * @param item 商品基本信息对象 包含了 商品分类id的
	 * @return 一个整数，如果大于0则表示添加成功
	 */
	int saveTbItem(TbItem item);
	
	
	
}
