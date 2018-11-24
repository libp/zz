package com.nichuiniu.service;


import com.github.pagehelper.PageInfo;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.util.ZzResult;

import java.util.List;

/**
 * Created by libp on 2018/7/14.
 */
public interface WanHGImgService {

    List<WanHGImg> selectImgByPage(String categroy);

    WanHGImg  getImageById(int id);

    List<WanHGImg>  getImgByTagID(int tagid);

    ZzResult updateByPrimaryKeySelective(WanHGImg record);

    List<WanHGImg> getImageByRandom(String categroy,int pageNum,int pageSize);

    int updateAuditImg(int deleted,String categroy);

    List<WanHGImg> selectImgByScores(String categroy);

    ZzResult deleteByPrimaryKey(int id);
}



