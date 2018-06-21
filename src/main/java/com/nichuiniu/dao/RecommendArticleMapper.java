package com.nichuiniu.dao;

import com.nichuiniu.model.RecommendArticle;

public interface RecommendArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendArticle record);

    int insertSelective(RecommendArticle record);

    RecommendArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendArticle record);

    int updateByPrimaryKey(RecommendArticle record);

    RecommendArticle selectNewestArticle();
}