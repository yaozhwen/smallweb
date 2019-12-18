package com.yao.core.entity;

import java.io.Serializable;

/**
 * Created by yaozwsq on 2019/12/16 13:52.
 */
public class AdminRole implements Serializable{
    private Long id;

    private String name;

    private Boolean defaultOrNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefaultOrNo() {
        return defaultOrNo;
    }

    public void setDefaultOrNo(Boolean defaultOrNo) {
        this.defaultOrNo = defaultOrNo;
    }
}
