package com.nichuiniu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.constant.WebConst;
import com.nichuiniu.model.SysParams;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.SysParamsService;
import com.nichuiniu.service.WanHGImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysParamsController
 * @Author libp
 * @Description
 * @Date 2018/8/8 21:24
 **/
@Controller
@RequestMapping(value = "/v1/sysParams")
public class SysParamsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysParamsService sysParamsService;

    @ResponseBody
    @GetMapping("/selectSysParams")
    public Object selectSysParams(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "usagescenario", required = false, defaultValue = "tag01")
                    String usagescenario,
            @RequestParam(name = "paramskey", required = false, defaultValue = "")
                    String paramskey){
        PageHelper.startPage(pageNum,pageSize);
        SysParams sysParams = new SysParams();
        sysParams.setUsagescenario(usagescenario);
        sysParams.setParamskey(paramskey);
        List<SysParams> list = sysParamsService.selectSysParams(sysParams);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @ResponseBody
    @PostMapping("/updateByPrimaryKeySelective")
    public Object updateByPrimaryKeySelective(@RequestBody String  sysParams){
        SysParams sys = JSONObject.parseObject(sysParams,SysParams.class);
        return sysParamsService.updateByPrimaryKeySelective(sys);
    }

    @ResponseBody
    @GetMapping("/selectSysParamsValue")
    public Object selectSysParamsValue(){
        return sysParamsService.selectSysParamsValue(WebConst.TENCENT_REVIEW);
    }

    @ResponseBody
    @GetMapping("/updateParamsValueByKey")
    public Object updateParamsValueByKey(@RequestParam(name = "paramsValue", required = false, defaultValue = "")
                                                     String paramsValue,
                                         @RequestParam(name = "paramsKey", required = false, defaultValue = "")
                                                 String paramsKey){
        return sysParamsService.updateParamsValueByKey(paramsValue,paramsKey);
    }

}
