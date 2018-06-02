package com.nichuiniu.service.impl;

import com.nichuiniu.dao.ArticleMapper;
import com.nichuiniu.dao.UserMapper;
import com.nichuiniu.model.Article;
import com.nichuiniu.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by libp on 2018/5/23 22:19
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article selectByPrimaryKey(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Article random(String category) {
        return articleMapper.random(category);
    }

    @Override
    public Article recommend(String category) {
        return articleMapper.recommend(category);
    }

    @Override
    public Article articleID(int id) {
        return articleMapper.articleID(id);
    }
}
