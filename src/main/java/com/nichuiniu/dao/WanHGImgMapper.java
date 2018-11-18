package com.nichuiniu.dao;

import com.nichuiniu.model.WanHGImg;
import org.apache.ibatis.annotations.Param;

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

    List<WanHGImg>  getImgByTagID(int tagid);

    List<WanHGImg>  selectImgByIdList(List<Integer> list);

    List<Integer> getAllImgId(@Param("category") String category);

    int updateAuditImg(@Param("deleted") int deleted,@Param("category") String category);

    List<WanHGImg> selectImgByScores(@Param("category") String category);
}