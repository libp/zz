package com.nichuiniu.dao;

import com.nichuiniu.model.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    int insertRecommend(int id);

    Article selectByPrimaryKey(Integer id);

    Article random(String category);

    Article recommend(String category);

    Article articleID(int id);

    int selectNextArticle(int id);

    List<Article> selectArticleByPage();

    List<Article> selectRecommendByPage();

    int deleteRecommendById(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    int selectArticleCount();

    int selectRecommendArticleCount();
}