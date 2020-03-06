package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clive.bean.TbContent;
import com.clive.bean.TbContentCategory;

public interface TbContentMapper {
	/**
	 * 根据父级id查询内容分类信息 得到内容分类信息集合对象
	 * @param parentId 内容分类父级id
	 * @return 内容分类信息集合对象
	 */
	List<TbContentCategory> findTbContentByParentId(Long parentId);
	/**
	 * 根据内容分类id 查询内容信息
	 * @param categoryId 分类id
	 * @param limit 每页显示条数
	 * @param currentPage 当前索引
	 * @return 指定内容分类id下的内容信息
	 */
	List<TbContent> findTbContentByCategoryId(@Param("categoryId")Long categoryId, @Param("currentIndex")int currentIndex, @Param("limit")Integer limit);
	/**
	 * 根据分类id来查询内容总记录条数
	 * @param categoryId 分类id
	 * @return 该分类id所属内容的总记录条数
	 */
	int findTbContentCountByCategoryId(Long categoryId);
	
}
