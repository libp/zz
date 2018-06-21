package com.nichuiniu.model;

import java.util.Date;

public class RecommendArticle {
    private Integer id;

    private Integer recommendid;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecommendid() {
        return recommendid;
    }

    public void setRecommendid(Integer recommendid) {
        this.recommendid = recommendid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}