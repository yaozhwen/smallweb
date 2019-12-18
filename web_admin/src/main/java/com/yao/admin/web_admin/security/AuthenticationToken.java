package com.yao.admin.web_admin.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by yaozwsq on 2019/12/16 14:48.
 */
public class AuthenticationToken extends UsernamePasswordToken {

    private static final long serialVersionUID = -5147741537242547796L;

    private String loginType;

    private String captcha;

    public AuthenticationToken(String username, String password, boolean rememberMe, String host, String loginType,String captcha){
        super(username, password, rememberMe, host);
        this.loginType = loginType;
        this.captcha = captcha;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
