package com.nichuiniu.dao;

import com.nichuiniu.model.SysParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysParamsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParams record);

    int insertSelective(SysParams record);

    SysParams selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysParams record);

    int updateByPrimaryKey(SysParams record);

    List<SysParams> selectSysParams(SysParams sysParams);

    String selectSysParamsValue(@Param("paramsKey") String paramsKey);

    int updateParamsValueByKey(@Param("paramsValue") String paramsValue,@Param("paramsKey") String paramsKey);
}