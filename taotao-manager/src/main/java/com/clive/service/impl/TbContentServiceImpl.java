package com.clive.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbContent;
import com.clive.bean.TbContentCategory;
import com.clive.common.Data;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbContentMapper;
import com.clive.service.TbContentService;
@Service
public class TbContentServiceImpl implements TbContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	@Override
	public List<ZTreeNodeResult> findTbContentById(Long parentId) {
		List<TbContentCategory> contentCategorys = tbContentMapper.findTbContentByParentId(parentId);
		List<ZTreeNodeResult> result = new ArrayList<ZTreeNodeResult>();
		for (TbContentCategory category : contentCategorys) {
			ZTreeNodeResult node = new ZTreeNodeResult();
			node.setId(category.getId());
			node.setName(category.getName());
			node.setIsParent(category.getIsParent());
			result.add(node);
		}
		return result;
	}
	@Override
	public LayuiTableResult findTbContentByCategoryId(Long categoryId, Integer page, Integer limit) {
		LayuiTableResult result = new LayuiTableResult();
		result.setCode(0);
		result.setMsg("");
		int count = tbContentMapper.findTbContentCountByCategoryId(categoryId);
		result.setCount(count);
		List<TbContent> data = tbContentMapper.findTbContentByCategoryId(categoryId,(page-1)*limit,limit);
		result.setData(data);
		return result;
	}
	@Override
	public LayuiTableResult deleteContentByCategroyIds(List<TbContent> tbContents,Integer page, Integer limit) {
		/**
		 * 1.传入一个集合的id 然后执行删除语句
		 * 2.传入一个分类id 查询该分类下的内容信息
		 * 然后把内容信息组装好 返回给页面
		 */
		LayuiTableResult result = new LayuiTableResult();
		result.setCode(0);
		result.setMsg("");
		List<Long> ids = new ArrayList<Long>();
		for (TbContent content : tbContents) {
			ids.add(content.getId());
		}
		
		int contentCount = tbContentMapper.deleteContent(ids);
		if(contentCount<=0){
			return result;
		}
		int count = tbContentMapper.findTbContentCountByCategoryId(tbContents.get(0).getCategoryId());
		if(count<=0){
			return result;
		}
		//删除了内容以后 还可以得到数据 再来查询数据
		
		result.setCount(count);
		List<TbContent> data = tbContentMapper.findTbContentByCategoryId(tbContents.get(0).getCategoryId(),(page-1)*limit,limit);
		result.setData(data);
		return result;
	}
	@Override
	public TaotaoResult addContent(TbContent tbContent) {
		/**
		 * 创建时间 和 更新时间没有值的 我们要自己给值
		 * id 不用给 主键自增长
		 */
		Date date = new Date();
		tbContent.setCreated(date);
		tbContent.setUpdated(date);
		int count = tbContentMapper.addContent(tbContent);
		if(count<=0){
			return TaotaoResult.build(500, "添加失败");
		}
		
		return TaotaoResult.build(200, "添加成功");
	}
	

}
