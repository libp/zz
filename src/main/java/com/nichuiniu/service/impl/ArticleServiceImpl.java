package com.nichuiniu.service.impl;

import com.nichuiniu.dao.ArticleMapper;
import com.nichuiniu.dao.RecommendArticleMapper;
import com.nichuiniu.model.Article;
import com.nichuiniu.model.RecommendArticle;
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

    @Autowired
    private RecommendArticleMapper recommendArticleMapper;

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
    public int selectNextArticle(int id) {
        return articleMapper.selectNextArticle(id);
    }

    @Override
    public List<Article> selectArticleByPage() {
        return articleMapper.selectArticleByPage();
    }

    @Override
    public List<Article> selectRecommendByPage() {
        return articleMapper.selectRecommendByPage();
    }

    @Override
    public ZzResult deleteRecommendById(Integer id) {
        boolean flag = true;
        String message = "删除成功";
        try {
            articleMapper.deleteRecommendById(id);
        } catch(Exception e) {
            flag = false;
            message = "删除失败:";
            logger.error(message, e);
        }
        ZzResult result = new ZzResult(flag, message);
        return result;
    }

    @Override
    public ZzResult deleteByPrimaryKey(Integer id) {
        boolean flag = true;
        String message = "删除成功";
        try {
            articleMapper.deleteByPrimaryKey(id);
        } catch(Exception e) {
            flag = false;
            message = "删除失败:";
            logger.error(message, e);
        }
        ZzResult result = new ZzResult(flag, message);
        return result;
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

    @Override
    public int selectRecommendArticleCount() {
        return articleMapper.selectRecommendArticleCount();
    }

    @Override
    public int selectArticleCount() {
        return articleMapper.selectArticleCount();
    }

    @Override
    public RecommendArticle selectNewestArticle() {
        return recommendArticleMapper.selectNewestArticle();
    }
}
