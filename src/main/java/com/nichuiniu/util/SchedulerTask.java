package com.nichuiniu.util;

import com.nichuiniu.model.Article;
import com.nichuiniu.model.GuShiWen;
import com.nichuiniu.model.RecommendArticle;
import com.nichuiniu.service.ArticleService;
import com.nichuiniu.service.GuShiWenService;
import com.nichuiniu.service.SysParamsService;
import com.nichuiniu.service.WanHGImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by libp on 2018/6/20 22:42
 */
@Component
public class SchedulerTask {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private GuShiWenService guShiWenService;

    private static final SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description: 定时推荐值得读读文章
     * @Param: []
     * @return: void
     * @Author: Libp
     * @Date: 2019/1/1
     */
    @Scheduled(cron="0 0 22 * * ?")
    private void process(){
        RecommendArticle recommendArticle = articleService.selectNewestArticle();

        Date begin = recommendArticle.getCreatetime();
        Date now = new Date();
        long hours=0;
        hours = (now.getTime()-begin.getTime())/ (1000 * 60 * 60);
        if(hours<24) {
            logger.info(now.getTime()+" not need to update.last update time is "+hours+ "hours ago");
        }else {
            int nextid = articleService.selectNextArticle(recommendArticle.getRecommendid());
            if(nextid!=0){
                articleService.insertRecommend(nextid);
                logger.info(now.getTime()+" auto update .last update time is "+hours+ "hours ago");
            }
        }
    }

    /**
     * @Description: 定时推荐古诗文
     * @Param: []
     * @return: void
     * @Author: Libp
     * @Date: 2019/1/1
     */
    @Scheduled(cron="0 0 21 * * ?")
    private void gushiwen(){
        GuShiWen guShiWen = guShiWenService.selectByRandom();
        int nextid = guShiWen.getId();
        guShiWenService.insertRecommend(nextid);
    }

}
