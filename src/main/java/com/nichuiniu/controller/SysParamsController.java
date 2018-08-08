package com.nichuiniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.SysParams;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.SysParamsService;
import com.nichuiniu.service.WanHGImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
