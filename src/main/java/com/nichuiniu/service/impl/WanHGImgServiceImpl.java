package com.nichuiniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nichuiniu.dao.WanHGImgMapper;
import com.nichuiniu.model.WanHGImg;
import com.nichuiniu.service.WanHGImgService;
import com.nichuiniu.util.ZzResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public List<WanHGImg> getImgByTagID(int tagid) {
        return wanHGImgMapper.getImgByTagID(tagid);
    }

    @Override
    public ZzResult updateByPrimaryKeySelective(WanHGImg record) {
        boolean flag = true;
        String message = "更新成功";
        try {
            wanHGImgMapper.updateByPrimaryKeySelective(record);
        } catch(Exception e) {
            flag = false;
            message = "更新失败:";
            logger.error(message, e);
        }
        ZzResult result = new ZzResult(flag, message);
        return result;
    }

    @Override
    public List<WanHGImg> getImageByRandom(String category,int pageNum,int pageSize) {
        List<Integer> idList = wanHGImgMapper.getAllImgId(category);
//        logger.info("this one get idList id is:" + idList.toString());
        List<Integer> indexList = new ArrayList<>();
        Random index = new Random();
        for(int i=0,j;i<pageSize;i++){
            j = index.nextInt(idList.size());
            if(!indexList.contains(idList.get(j))){
                indexList.add(idList.get(j));
            }else{
                i--;
            }
        }
        logger.info("this one get random img id is:" + indexList.toString());

        return wanHGImgMapper.selectImgByIdList(indexList);
    }

    @Override
    public int updateAuditImg(int deleted,String categroy) {
        return wanHGImgMapper.updateAuditImg(deleted,categroy);
    }

    @Override
    public List<WanHGImg> selectImgByScores(String categroy) {
        return wanHGImgMapper.selectImgByScores(categroy);
    }


}
