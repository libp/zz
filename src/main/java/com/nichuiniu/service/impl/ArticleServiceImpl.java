package com.nichuiniu.service.impl;

import com.nichuiniu.dao.ArticleMapper;
import com.nichuiniu.model.Article;
import com.nichuiniu.service.ArticleService;

import com.nichuiniu.util.ZzResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by libp on 2018/5/23 22:19
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Override
    public List<Article> selectArticleByPage() {
        return articleMapper.selectArticleByPage();
    }

    @Override
    public ZzResult insertRecommend(int id){
        boolean flag = true;
        String message = "文章推荐成功";
        try {
            articleMapper.insertRecommend(id);
        } catch(Exception e) {
            flag = false;
            message = "文章推荐失败:";
            logger.error(message, e);
        }
        ZzResult result = new ZzResult(flag, message);
        return result;
    }
}
