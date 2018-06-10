package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.Article;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.util.ZzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by libp on 2018/5/23 21:38
 */
@Controller
@RequestMapping(value = "/v1/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping("/random")
    public Object getRandomContent(
            @RequestParam(name = "category", required = false, defaultValue = "z1")
                    String category){
        return articleService.random(category);
    }

    @ResponseBody
    @GetMapping("/recommend")
    public Object getRecommendContent(
            @RequestParam(name = "category", required = false, defaultValue = "z1")
                    String category){
        return articleService.recommend(category);
    }

    @ResponseBody
    @GetMapping("/articleID")
    public Object getArticleById(
            @RequestParam(name = "id", required = false, defaultValue = "145528")
                    int id){
        return articleService.articleID(id);
    }

    @ResponseBody
    @GetMapping("/insertRecommend")
    public ZzResult insertRecommend(
            @RequestParam(name = "id", required = false, defaultValue = "145528")
                    int id){
        return articleService.insertRecommend(id);
    }

    @ResponseBody
    @DeleteMapping("/deleteRecommendById")
    public ZzResult deleteRecommendById(
            @RequestParam(name = "id", required = true)
                    int id){
        return articleService.deleteRecommendById(id);
    }

    @ResponseBody
    @GetMapping("/selectArticleByPage")
    public Object selectArticleByPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleService.selectArticleByPage();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @GetMapping("/selectRecommendByPage")
    public Object selectRecommendByPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleService.selectRecommendByPage();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @GetMapping("/selectArticleCount")
    public int selectArticleCount(){
        return articleService.selectArticleCount();
    }

    @ResponseBody
    @GetMapping("/selectRecommendArticleCount")
    public int selectRecommendArticleCount(){
        return articleService.selectRecommendArticleCount();
    }
}
