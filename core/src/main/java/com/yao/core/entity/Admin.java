package com.yao.core.entity;

import com.yao.core.common.Constants;
import com.yao.core.persistence.BaseEntity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class Admin extends BaseEntity<Admin> {
    /*角色ID*/
    private Long roleId;

    private String name;

    @Pattern(regexp = Constants.PHONE_REG_EXP,message = "手机号格式错误")
    @NotBlank(message = "手机号不可为空")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;

    /*状态 0：申请中，1：开放，2：冻结*/
    private Integer status;

    private String username;

    private String pwd;

    /*最后登录时间*/
    private Date loginDate;

    /*是否被锁*/
    private Boolean lockedOrNo;

    /*锁定日期*/
    private Date lockedDate;

    /*登录失败次数，超过5次被锁*/
    private Integer loginFailureCount;

    /*U盾ID*/
    private String passId;

    // 是否首次修改 默认1（是）
    private Boolean firstLogin;
    // 修改登录密码时间
    private Date editLoginPwdTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Boolean getLockedOrNo() {
        return lockedOrNo;
    }

    public void setLockedOrNo(Boolean lockedOrNo) {
        this.lockedOrNo = lockedOrNo;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getEditLoginPwdTime() {
        return editLoginPwdTime;
    }

    public void setEditLoginPwdTime(Date editLoginPwdTime) {
        this.editLoginPwdTime = editLoginPwdTime;
    }
}
