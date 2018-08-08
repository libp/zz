package com.nichuiniu.dao;

import com.nichuiniu.model.WanHGImg;

import java.util.List;

public interface WanHGImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WanHGImg record);

    int insertSelective(WanHGImg record);

    WanHGImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WanHGImg record);

    int updateByPrimaryKeyWithBLOBs(WanHGImg record);

    int updateByPrimaryKey(WanHGImg record);

    List<WanHGImg> selectImgByPage(String categroy);

    WanHGImg  getImageById(int id);
}