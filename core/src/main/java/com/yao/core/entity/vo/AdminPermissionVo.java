package com.yao.core.entity.vo;

import java.util.List;

/**
 * Created by yaozwsq on 2019/12/17 11:18.
 */
public class AdminPermissionVo {
    private Long id;

    private String name;

    private String icon;

    private String permission;

    private String url;

    private Long parentId;

    private Integer grade;

    /*类型，1：菜单，2：按钮*/
    private Integer type;

    /*排序*/
    private Integer orders;

    private Long rid;

    private List<AdminPermissionVo> list;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public List<AdminPermissionVo> getList() {
        return list;
    }

    public void setList(List<AdminPermissionVo> list) {
        this.list = list;
    }
}
