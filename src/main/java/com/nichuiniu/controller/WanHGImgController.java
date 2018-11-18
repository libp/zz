package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.constant.WebConst;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.SysParamsService;
import com.nichuiniu.service.WanHGImgService;
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

    @Autowired
    private SysParamsService sysParamsService;

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
            @RequestParam(name = "id", required = false, defaultValue = "500")
                    int id){
        return wanHGImgService.getImageById(id);
    }

    @ResponseBody
    @GetMapping("/getImgByTagID")
    public Object getImgByTagID(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "tagid", required = false, defaultValue = "20")
                    int tagid){
        PageHelper.startPage(pageNum,pageSize);
        List<WanHGImg> list = wanHGImgService.getImgByTagID(tagid);
        PageInfo page = new PageInfo(list);
        return page;
    }

    /**
     *
     * @param id
     * @param scores 点击+2，收藏+5，点赞+1，被选机选中时-2
     * @return
     */
    @ResponseBody
    @GetMapping("/updateByPrimaryKeySelective")
    public Object updateByPrimaryKeySelective(
            @RequestParam(name = "id", required = false, defaultValue = "500")
                    int id,
            @RequestParam(name = "scores", required = false, defaultValue = "1")
                    int scores){
        WanHGImg whg = wanHGImgService.getImageById(id);
        whg.setId(id);
        scores = scores + whg.getScores();
        whg.setScores(scores);
        return wanHGImgService.updateByPrimaryKeySelective(whg);
    }

    @ResponseBody
    @GetMapping("/getImageByRandom")
    public Object getImageByRandom(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "category", required = false)
                    String category){

        String  auditSwitch = sysParamsService.selectSysParamsValue(WebConst.TENCENT_REVIEW);
        if(auditSwitch!=null && auditSwitch.equalsIgnoreCase("TRUE")){
            return wanHGImgService.getImageByRandom(WebConst.GREEN_IMG,pageNum,pageSize);
        }
        return wanHGImgService.getImageByRandom(category,pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/updateAuditImg")
    public Object updateAuditImg(@RequestParam(name = "deleted", required = false, defaultValue = "1")
                                 int deleted){
        return wanHGImgService.updateAuditImg(deleted,WebConst.GREEN_IMG);
    }

    @ResponseBody
    @GetMapping("/selectImgByScores")
    public Object selectImgByScores(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){



        String  auditSwitch = sysParamsService.selectSysParamsValue(WebConst.TENCENT_REVIEW);
        if(auditSwitch!=null && auditSwitch.equalsIgnoreCase("TRUE")){
            PageHelper.startPage(pageNum,pageSize);

            List<WanHGImg> list = wanHGImgService.selectImgByScores(WebConst.GREEN_IMG);
            PageInfo page = new PageInfo(list);
            return  page;
        }else{
            PageHelper.startPage(pageNum,pageSize);
            List<WanHGImg> list = wanHGImgService.selectImgByScores(null);
            PageInfo page = new PageInfo(list);
            return  page;
        }
    }
}
