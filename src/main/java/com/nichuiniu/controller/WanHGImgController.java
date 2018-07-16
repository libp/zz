package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.Article;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.service.WanHGImgService;
import com.nichuiniu.util.ZzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by libp on 2018/7/14 23:14
 */
@Controller
@RequestMapping(value = "/v1/wanHGImg")
public class WanHGImgController {

    @Autowired
    private WanHGImgService wanHGImgService;

    @ResponseBody
    @GetMapping("/selectImgByPage")
    public Object selectImgByPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "category", required = false, defaultValue = "rihan")
                    String category){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<WanHGImg> list = wanHGImgService.selectImgByPage(category);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @GetMapping("/getImageById")
    public Object getImageById(
            @RequestParam(name = "id", required = false, defaultValue = "483")
                    int id){
        return wanHGImgService.getImageById(id);
    }


}
