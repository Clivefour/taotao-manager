package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;
import com.clive.bean.TbItemCat;
import com.clive.common.ItemCat;
import com.clive.common.ItemCatResult;
import com.clive.mapper.TbItemCatMapper;
import com.clive.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public ItemCatResult getItemCats(long id) {
		ItemCatResult result = new ItemCatResult();
		result.setData(getItemCateResult(id));
		return result;
	}
	
	/**
	 * 因为我们分析了我们需要递归的，原因在于  我不知道 一级分类下有多少个二级分类
	 * 而二级分类下有多少个三级分类
	 *   自己调用自己
	 *   满足一定条件 就调用自己 完成 所有的查询以后 就返回信息
	 */
	private List<?> getItemCateResult(long id){
		/**
		 * 默认id 等于0  请求一级分类数据 遍历也是遍历以及分类数据 假设一级分类有18个 for循环18次
		 *  data:18个对象
		 *  但是 由于递归的关系 我们又传递了一个1进去
		 *  但是又进行了递归 所以id=2又再次传入进去了
		 */
		List<TbItemCat> itemCatByParentId = tbItemCatMapper.getItemCatByParentId(id);
		//新的list集合对象
		List data = new ArrayList();
		int count = 0; 
		//根据默认的id等于0查询到一级类目下的所有信息 id=0的时候循环18次 id等于1的时候循环12次
		for (TbItemCat tbItemCat : itemCatByParentId) {
			//u和n和i  是一个新对象
			ItemCat item = new ItemCat();
			//
			if(tbItemCat.getIsParent()){
				/**
				 * 一级类目和二级类目的u一样
				 * 但是 name不一样
				 */
				item.setUrl("/products/"+tbItemCat.getId()+".html");
				//他是一级类目
				if(id==0){
					item.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				}else{
					//他是二级类目
					item.setName(tbItemCat.getName());
				}
				count++;
				//设置i  等于1 由于代码走到了这里 进行了递归 所以代码没有继续往下执行
				item.setItem(getItemCateResult(tbItemCat.getId()));
				//一级类目 和二级类目 装到集合里面去
				data.add(item);
				//因为是一级目录不能超出红色的位置  而一级目录的特点是id等于0 所以两个条件同时成立
				if(id==0&&count>=14){
					break;
				}
			}else{
				/**
				 * 三级类目的逻辑
				 * /products/1.html|电子书
				 */
				
				data.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
			}
		}
		return data;
	}
}
