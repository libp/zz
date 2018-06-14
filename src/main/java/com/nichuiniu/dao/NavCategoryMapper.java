package com.nichuiniu.dao;

import com.nichuiniu.model.NavCategory;

public interface NavCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NavCategory record);

    int insertSelective(NavCategory record);

    NavCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NavCategory record);

    int updateByPrimaryKey(NavCategory record);

}