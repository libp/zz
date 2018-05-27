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
public class RandomController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping("/random")
    public Object getRandomContent(){
        String  category = "z1";
        return articleService.random(category);
    }

    @ResponseBody
    @GetMapping("/recommend")
    public Object getRecommendContent(){
        String  category = "z1";
        return articleService.recommend(category);
    }
}
