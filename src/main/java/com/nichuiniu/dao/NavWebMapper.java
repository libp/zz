package com.nichuiniu.dao;

import com.nichuiniu.model.Article;
import com.nichuiniu.model.NavWeb;

import java.util.List;

public interface NavWebMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NavWeb record);

    int insertSelective(NavWeb record);

    NavWeb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NavWeb record);

    int updateByPrimaryKey(NavWeb record);

    List<NavWeb> selectNavByCategoryID(int id);
}