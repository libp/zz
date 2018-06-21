package com.nichuiniu.service.impl;

import com.nichuiniu.dao.ArticleMapper;
import com.nichuiniu.dao.NavCategoryMapper;
import com.nichuiniu.dao.NavWebMapper;
import com.nichuiniu.model.Article;
import com.nichuiniu.model.NavCategory;
import com.nichuiniu.model.NavWeb;
import com.nichuiniu.service.NavService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by libp on 2018/6/15 7:29
 */
@Service(value ="navService")
public class NavServiceImpl implements NavService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NavWebMapper navWebMapper;

    @Autowired
    private NavCategoryMapper navCategoryMapper;


    @Override
    public Map<String, List<NavWeb>> selectNav() {

        Map<String, List<NavWeb>> map = new HashMap<String,  List<NavWeb>>();
        List<NavCategory> listCategory = navCategoryMapper.selectNavCategoryId();
        for(NavCategory category:listCategory){
            List<NavWeb> listWeb = navWebMapper.selectNavByCategoryID(category.getId());
            map.put(category.getCategory(), listWeb);
        }
        return map;
    }
}
