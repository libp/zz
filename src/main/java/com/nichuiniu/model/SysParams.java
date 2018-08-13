package com.nichuiniu.model;

import java.util.Date;

public class SysParams {
    private Integer id;

    private String paramskey;

    private String paramsvalue;

    private String paramsname;

    private String usagescenario;

    private Date createtime;

    private Date updatetime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamskey() {
        return paramskey;
    }

    public void setParamskey(String paramskey) {
        this.paramskey = paramskey == null ? null : paramskey.trim();
    }

    public String getParamsvalue() {
        return paramsvalue;
    }

    public void setParamsvalue(String paramsvalue) {
        this.paramsvalue = paramsvalue == null ? null : paramsvalue.trim();
    }

    public String getParamsname() {
        return paramsname;
    }

    public void setParamsname(String paramsname) {
        this.paramsname = paramsname == null ? null : paramsname.trim();
    }

    public String getUsagescenario() {
        return usagescenario;
    }

    public void setUsagescenario(String usagescenario) {
        this.usagescenario = usagescenario == null ? null : usagescenario.trim();
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}