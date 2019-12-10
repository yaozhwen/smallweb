package com.yao.core.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public abstract class BaseEntity<T> extends GsonBean implements Serializable{
    protected Long id;

    protected Date createDate;

    protected Date modifyDate;

    protected String createUser;

    protected String modifyUser;
    // 0-未删除 1- 删除
    protected Boolean delFlag;

    public BaseEntity(  String createUser, String modifyUser) {
        this.createDate = new Date();
        this.modifyDate = new Date();
        this.createUser = createUser;
        this.modifyUser = modifyUser;
        this.delFlag = false;
    }

    public BaseEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", createUser='" + createUser + '\'' +
                ", modifyUser='" + modifyUser + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
