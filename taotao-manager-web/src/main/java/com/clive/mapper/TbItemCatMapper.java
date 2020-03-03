package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.clive.bean.TbItemCat;

public interface TbItemCatMapper {
	@Select("SELECT * FROM tbitemcat WHERE parentId = #{id}")
	List<TbItemCat> getItemCatByParentId(long id);

}
