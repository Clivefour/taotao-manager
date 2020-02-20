package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbItemParamGroup;
import com.clive.bean.TbItemParamKey;
import com.clive.common.TaotaoResult;
import com.clive.mapper.TbItemParamMapper;
import com.clive.service.TbItemParamService;
import com.mysql.fabric.xmlrpc.base.Array;
@Service
public class TbItemParamServiceImpl implements TbItemParamService {
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	
	@Override
	public TaotaoResult findTbItemGroupByCId(Long cId) {
		TaotaoResult result = new TaotaoResult();
	 	List<TbItemParamGroup> group = tbItemParamMapper.findTbItemGroupByCid(cId);
		if(group.size()<=0){
			result.setStatus(500);
			result.setMsg("该分类没有规格参数模板，请去创建规格参数模板");
			return result;
		}
		result.setStatus(200);
		result.setMsg("有规格参数模板");
		result.setData(group);
		return result;
	}

	@Override
	public TaotaoResult addItemParamTemplate(Long cId, String params) {
		List<TbItemParamGroup> groups = new ArrayList<TbItemParamGroup>();
		String[] split = params.split("clive");
		for(int i = 0;i<split.length;i++){//循环两次 第一
			TbItemParamGroup g = new TbItemParamGroup();
			String string = split[i];
			String[] split2 = string.split(",");
			List<TbItemParamKey> itemParamKeys = new ArrayList<TbItemParamKey>();
			for(int j = 0;j<split2.length;j++){
				if(j==0){
					g.setGroupName(split2[j]);
				}else{
					TbItemParamKey itemParamKey = new TbItemParamKey();
					itemParamKey.setParamName(split2[j]);
					itemParamKeys.add(itemParamKey);
				}
			}
			g.setParamKeys(itemParamKeys);
			groups.add(g);
		}
		for (TbItemParamGroup group : groups) {
			group.setItemCatId(cId);
		}
		//到了这里以后  商品规格参数组 里面 所有数据都有了  有组名 和分类id了  还有每个组 对应的项
		//才能够做 规格参数组合规格参数项的添加
		int i = tbItemParamMapper.addParamGroup(groups);
		if(i<=0){
			return TaotaoResult.build(500, "添加规格参数失败");
		}else{
			List<TbItemParamGroup> itemParamGroups = tbItemParamMapper.findTbItemGroupsBycId(cId);
			for(int j = 0;j<groups.size();j++){
				TbItemParamGroup dataBaseGroup = itemParamGroups.get(j);
				TbItemParamGroup javaGroup = groups.get(j);
				if(dataBaseGroup.getGroupName().equals(javaGroup.getGroupName())){
					List<TbItemParamKey> paramKeys = javaGroup.getParamKeys();
					for (TbItemParamKey tbItemParamKey : paramKeys) {
						tbItemParamKey.setGroupId(dataBaseGroup.getId());
					}
				}
			}
		}
		
		for (TbItemParamGroup group : groups) {
			List<TbItemParamKey> paramKeys = group.getParamKeys();
			int j =tbItemParamMapper.addParamGroupKeys(paramKeys);
			if(j<=0){
				return TaotaoResult.build(500, "添加规格参数失败");
			}
		}
		
		return TaotaoResult.build(200, "添加成功");
	}

}
