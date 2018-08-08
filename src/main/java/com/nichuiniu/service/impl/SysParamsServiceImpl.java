package com.nichuiniu.service.impl;

import com.nichuiniu.dao.SysParamsMapper;
import com.nichuiniu.dao.WanHGImgMapper;
import com.nichuiniu.model.SysParams;
import com.nichuiniu.service.SysParamsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysParamsServiceImpl
 * @Author libp
 * @Description
 * @Date 2018/8/8 21:20
 **/
@Service(value = "sysParamsService")
public class SysParamsServiceImpl implements SysParamsService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysParamsMapper sysParamsMapper;

    @Override
    public List<SysParams> selectSysParams(SysParams sysParams) {
        return sysParamsMapper.selectSysParams(sysParams);
    }
}
