package com.nichuiniu.service;

import com.nichuiniu.model.GuShiWen;
import com.nichuiniu.util.ZzResult;

import java.util.List;

/**
 * @ClassName GuShiWenService
 * @Author libp
 * @Description
 * @Datetime 2019/1/1 11:14
 **/
public interface GuShiWenService {
    /***
     * 通过ID查询古诗文
     * @return
     */
    GuShiWen selectByPrimaryKey(Integer id);

    /***
     * 根据ID list查询古诗文
     * @return
     */
    List<GuShiWen> selectByIdList(List<Integer> list);

    /***
     * 获取所有文章的ID
     * @return
     */
    List<Integer> getAllId();

    /***
     * 根据得分查询排行
     * @return
     */
    List<GuShiWen> selectByScores();

    /***
     * 随机推荐古诗文
     * @return
     */
    GuShiWen selectByRandom();

    /***
     * 古诗文数
     * @return
     */
    int selectGuShiWenCount();

    /***
     * 推荐的古诗文数
     * @return
     */
    int selectRecommendGuShiWenCount();

    /***
     * 插入推荐的古诗文数
     * @return
     */
    ZzResult insertRecommend(int id);
}
