package com.nichuiniu.service;

import com.nichuiniu.model.Article;
import com.nichuiniu.model.NavWeb;
import com.nichuiniu.util.ZzResult;

import java.util.List;
import java.util.Map;


/**
 * Created by libp on 2018/5/23 22:05
 */
public interface NavService {


    Map<String, List<NavWeb>> selectNav();

}
