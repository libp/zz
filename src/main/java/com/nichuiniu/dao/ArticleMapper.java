package com.nichuiniu.dao;

import com.nichuiniu.model.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    Article random(String category);

    Article recommend(String category);

    Article articleID(int category);

    List<Article> selectArticleByPage();


    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}