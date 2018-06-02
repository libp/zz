package com.nichuiniu.service;

import com.nichuiniu.model.Article;

/**
 * Created by libp on 2018/5/23 22:05
 */
public interface ArticleService {

    Article selectByPrimaryKey (int id);

    Article random(String category);

    Article recommend(String category);

    Article articleID(int id);

}
