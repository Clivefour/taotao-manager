package com.clive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbContent;
import com.clive.mapper.TbContentMapper;
import com.clive.service.TbContentService;
@Service
public class TbContentServiceImpl implements TbContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public List<TbContent> findContents(long categoryId) {
		/**
		 * 每一个 内容 需要的json格式可能不一样
		 * 广告位需要图片
		 * 但是淘淘快报 需要文字 
		 * 所以json格式不一样 但是他们的逻辑一样
		 * 都是根据分类id 查询内容信息 
		 * 我就在service里面 得到内容信息集合对象 在controller里面 组装数据 这样 可能轻松一点
		 */
		List<TbContent> tbContents = tbContentMapper.findContents(categoryId);
		return tbContents;
	}

}
