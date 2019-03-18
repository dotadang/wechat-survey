package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class baseDo implements Serializable {

    protected static final long serialVersionUID = 1L;
    //创建时间
    protected Date created = new Date();
    //修改时间
    protected Date updated = new Date();
    //创建人
    protected String createdBy ;
    //修改人
    protected String updatedBy;
    //修改次数
    protected Integer modificationNum = 1;

    /**
     * 设置：创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreated() {
        return created;
    }
    /**
     * 设置：修改时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    /**
     * 获取：修改时间
     */
    public Date getUpdated() {
        return updated;
    }
    /**
     * 设置：创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * 获取：创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * 设置：修改人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    /**
     * 获取：修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }
    /**
     * 设置：修改次数
     */
    public void setModificationNum(Integer modificationNum) {
        this.modificationNum = modificationNum;
    }
    /**
     * 获取：修改次数
     */
    public Integer getModificationNum() {
        return modificationNum;
    }
}
