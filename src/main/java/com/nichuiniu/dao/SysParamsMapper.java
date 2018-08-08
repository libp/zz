package com.nichuiniu.dao;

import com.nichuiniu.model.SysParams;

import java.util.List;

public interface SysParamsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParams record);

    int insertSelective(SysParams record);

    SysParams selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysParams record);

    int updateByPrimaryKey(SysParams record);

    List<SysParams> selectSysParams(SysParams sysParams);
}