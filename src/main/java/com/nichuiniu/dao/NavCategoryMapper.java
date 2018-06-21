package com.nichuiniu.dao;

import com.nichuiniu.model.Article;
import com.nichuiniu.model.NavCategory;
import com.nichuiniu.model.NavWeb;

import java.util.List;

public interface NavCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NavCategory record);

    int insertSelective(NavCategory record);

    NavCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NavCategory record);

    int updateByPrimaryKey(NavCategory record);

    List<NavCategory> selectNavCategoryId();

}