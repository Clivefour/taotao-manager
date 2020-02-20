package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbItemParamGroup;
import com.clive.bean.TbItemParamKey;
import com.clive.bean.TbItemParamValue;

public interface TbItemParamMapper {
	/**
	 * 根据分类id多表查询规格参数组和每个组对应的规格参数项
	 * @param cId 分类id
	 * @return 规格参数组和每一项对应的值
	 */
	List<TbItemParamGroup> findTbItemGroupByCid(Long cId);
	/**
	 * 往商品规格参数值表里面 写入数据
	 * @param tbItemParamValues
	 * @return
	 */
	int saveTbItemParamValue(@Param("tbItemParamValues")List<TbItemParamValue> tbItemParamValues);
	/**
	 * 添加规格参数组方法 
	 * @param groups 规格参数组集合对象 注意  id是主键自增长的 不用关心
	 * @return 如果大于0则表示添加成功
	 */
	int addParamGroup(@Param("groups")List<TbItemParamGroup> groups);
	/**
	 * 根据分类id只查询组信息
	 * @param cId 分类id
	 * @return 返回指定分类下所对应的Id
	 */
	List<Integer> findTbItemGroupIdBycId(Long cId);
	/**
	 * 插入规格参数项数据到数据库中
	 * @param paramKeys 规格参数项集合对象
	 * @return 如果大于0则表示添加成功 否则表示添加失败
	 */
	int addParamGroupKeys(@Param("paramKeys")List<TbItemParamKey> paramKeys);

}
