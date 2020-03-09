package com.clive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.clive.bean.TbContent;

public interface TbContentMapper {
	@Select("SELECT * FROM tbcontent WHERE categoryId = #{categoryId}")
	List<TbContent> findContents(long categoryId);

}
