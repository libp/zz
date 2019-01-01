package com.nichuiniu.dao;

import com.nichuiniu.model.GuShiWen;

import java.util.List;

public interface GuShiWenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GuShiWen record);

    int insertSelective(GuShiWen record);

    /***
     * 通过ID查询古诗文
     * @return
     */
    GuShiWen selectByPrimaryKey(Integer id);

    /***
     * 根据ID查询
     * @return
     */
    List<GuShiWen>  selectByIdList(List<Integer> list);

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
     * 插入推荐的古诗文
     * @return
     */
    int insertRecommend(int id);
}