package com.nichuiniu.controller;


import com.nichuiniu.service.NavService;
import com.nichuiniu.util.ZzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by libp on 2018/5/23 21:38
 */
@Controller
@RequestMapping(value = "/v1/nav")
public class NavController {

    @Autowired
    private NavService navService;

    @ResponseBody
    @GetMapping("/selectNav")
    public Object selectNav(){
        return navService.selectNav();
    }


}
