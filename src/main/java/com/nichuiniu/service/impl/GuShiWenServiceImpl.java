package com.nichuiniu.service.impl;

import com.nichuiniu.dao.GuShiWenMapper;
import com.nichuiniu.model.GuShiWen;
import com.nichuiniu.service.GuShiWenService;
import com.nichuiniu.util.ZzResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @ClassName GuShiWenServiceImpl
 * @Author libp
 * @Description
 * @Datetime 2019/1/1 11:15
 **/
@Service(value = "guShiWenService")
public class GuShiWenServiceImpl implements GuShiWenService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GuShiWenMapper guShiWenMapper;

    /***
     * 通过ID查询古诗文
     * @return
     * @param id
     */
    @Override
    public GuShiWen selectByPrimaryKey(Integer id) {
        return guShiWenMapper.selectByPrimaryKey(id);
    }

    /***
     * 根据ID查询
     * @return
     * @param list
     */
    @Override
    public List<GuShiWen> selectByIdList(List<Integer> list) {
        return guShiWenMapper.selectByIdList(list);
    }

    /***
     * 获取所有文章的ID
     * @return
     */
    @Override
    public List<Integer> getAllId() {
        return guShiWenMapper.getAllId();
    }

    /***
     * 根据得分查询排行
     * @return
     */
    @Override
    public List<GuShiWen> selectByScores() {
        return guShiWenMapper.selectByScores();
    }

    /***
     * 随机推荐古诗文
     * @return
     */
    @Override
    public GuShiWen selectByRandom() {
        List<Integer> idList = guShiWenMapper.getAllId();
        Random index = new Random();
        int id = idList.get(index.nextInt(idList.size()));
        return guShiWenMapper.selectByPrimaryKey(id);
    }

    /***
     * 古诗文数
     * @return
     */
    @Override
    public int selectGuShiWenCount() {
        return guShiWenMapper.selectGuShiWenCount();
    }

    /***
     * 推荐的古诗文数
     * @return
     */
    @Override
    public int selectRecommendGuShiWenCount() {
        return guShiWenMapper.selectRecommendGuShiWenCount();
    }

    /***
     * 插入推荐的古诗文数
     * @return
     * @param id
     */
    @Override
    public ZzResult insertRecommend(int id) {
        boolean flag = true;
        String message = "文章推荐成功";
        try {
            guShiWenMapper.insertRecommend(id);
        } catch(Exception e) {
            flag = false;
            message = "文章推荐失败:";
            logger.error(message, e);
        }
        ZzResult result = new ZzResult(flag, message);
        return result;
    }
}
