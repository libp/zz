package com.nichuiniu.service;

import com.nichuiniu.model.SysParams;

import java.util.List;

/**
 * @ClassName SysParamsService
 * @Author libp
 * @Description
 * @Date 2018/8/8 21:19
 **/
public interface SysParamsService {
    List<SysParams> selectSysParams(SysParams sysParams);
}
