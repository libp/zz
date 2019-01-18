package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.Article;
import com.nichuiniu.model.GuShiWen;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.service.GuShiWenService;
import com.nichuiniu.util.ZzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by libp on 2018/5/23 21:38
 */
@Controller
@RequestMapping(value = "/v1/gushiwen")
public class GushiwenController {

    @Autowired
    private GuShiWenService guShiWenService;

    /***
     * 随机推荐古诗文
     * @return
     */
    @ResponseBody
    @GetMapping("/selectByRandom")
    public Object selectByRandom(){
        return guShiWenService.selectByRandom();
    }

    /***
     * 获取最新推荐的古诗文
     * @return
     */
    @ResponseBody
    @GetMapping("/recommend")
    public GuShiWen recommend() {
        return guShiWenService.recommend();
    }

    @ResponseBody
    @GetMapping("/selectByPrimaryKey")
    public Object selectByPrimaryKey(
            @RequestParam(name = "id", required = false, defaultValue = "1361")
                    int id){
        return guShiWenService.selectByPrimaryKey(id);
    }

    @ResponseBody
    @GetMapping("/selectByScores")
    public Object selectByScores(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<GuShiWen> list = guShiWenService.selectByScores();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @GetMapping("/selectGuShiWenCount")
    public int selectGuShiWenCount(){
        return guShiWenService.selectGuShiWenCount();
    }

    @ResponseBody
    @GetMapping("/selectRecommendGuShiWenCount")
    public int selectRecommendGuShiWenCount(){
        return guShiWenService.selectRecommendGuShiWenCount();
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
        List<GuShiWen> list = guShiWenService.selectRecommendByPage();
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @GetMapping("/insertRecommend")
    public ZzResult insertRecommend(
            @RequestParam(name = "id", required = false, defaultValue = "1003")
                    int id){
        return guShiWenService.insertRecommend(id);
    }

    @ResponseBody
    @DeleteMapping("/deleteRecommendById")
    public ZzResult deleteRecommendById(
            @RequestParam(name = "id", required = true)
                    int id){
        return guShiWenService.deleteRecommendById(id);
    }

    @ResponseBody
    @DeleteMapping("/deleteByPrimaryKey")
    public ZzResult deleteByPrimaryKey(
            @RequestParam(name = "id", required = true)
                    int id){
        return guShiWenService.deleteByPrimaryKey(id);
    }
}
