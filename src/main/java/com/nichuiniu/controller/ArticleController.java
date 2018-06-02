package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.nichuiniu.model.User;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by libp on 2018/5/23 21:38
 */
@Controller
@RequestMapping(value = "/v1")
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
}
