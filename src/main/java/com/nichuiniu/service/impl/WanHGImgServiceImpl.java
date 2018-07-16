package com.nichuiniu.service.impl;

import com.nichuiniu.dao.WanHGImgMapper;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.WanHGImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by libp on 2018/7/14 23:08
 */
@Service(value = "wanHGImgService")
public class WanHGImgServiceImpl implements WanHGImgService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WanHGImgMapper wanHGImgMapper;

    @Override
    public List<WanHGImg> selectImgByPage(String categroy) {
        return wanHGImgMapper.selectImgByPage(categroy);
    }

    @Override
    public WanHGImg getImageById(int id) {
        return wanHGImgMapper.getImageById(id);
    }
}
