package com.nichuiniu.service;


import com.nichuiniu.model.WanHGImg;

import java.util.List;

/**
 * Created by libp on 2018/7/14.
 */
public interface WanHGImgService {

    List<WanHGImg> selectImgByPage(String categroy);
}



