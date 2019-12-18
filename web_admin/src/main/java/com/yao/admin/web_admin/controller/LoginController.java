package com.yao.admin.web_admin.controller;

import com.google.gson.Gson;
import com.yao.admin.web_admin.security.AuthenticationToken;
import com.yao.admin.web_admin.security.IncorrectCaptchaException;
import com.yao.admin.web_admin.security.NoRoleException;
import com.yao.core.common.Constants;
import com.yao.core.entity.Admin;
import com.yao.core.entity.AdminRole;
import com.yao.core.eureka.EurekaResponse;
import com.yao.facade.admin.AdminFeignClient;
import com.yao.facade.admin.AdminRoleFeignClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaozwsq on 2019/12/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController extends BaseController {

    @Resource
    private AdminFeignClient adminFeignClient;

    @Resource
    private AdminRoleFeignClient adminRoleFeignClient;

    @RequestMapping(value = "/hello")
    public String index(Model model){
        logger.info("login-index");
        /*request.getSession().removeAttribute(Constants.ADMIN_SESSION_BEAN);

        Subject subject = SecurityUtils.getSubject();
        if (subject!=null){
            subject.logout();
        }*/
        Admin admin = new Admin();
        admin.setUsername("testOrigin");
        admin.setPwd("pwdOrigin");
        model.addAttribute("userInfo",admin);
        return "hello";
    }

    @RequestMapping(value = "/add")
    public String add(Model model, @Validated Admin admin, BindingResult rs,HttpServletRequest request){
        logger.info("login-add");
        model.addAttribute("userInfo",admin);
        String username = request.getParameter("username");
        String password = request.getParameter("pwd").trim();
        String loginType = request.getParameter(Constants.LOGINTYPE).trim();
        String captcha = request.getParameter(Constants.CAPTCHA).trim();
        Subject subject = SecurityUtils.getSubject();
        String ip = request.getRemoteAddr();

        AuthenticationToken token = new AuthenticationToken(username,password,false,ip,loginType,captcha);

        try {
            subject.login(token);
        }catch (Exception e){
            String msg = "";
            if (e instanceof IncorrectCaptchaException) {
                msg = "验证码不对";
            } else if (e instanceof UnknownAccountException) {
                msg = "帐号或者密码错误";
            } else if (e instanceof DisabledAccountException) {
                msg = "帐号未开放";
            } else if (e instanceof IncorrectCredentialsException) {
                msg = "帐号或者密码错误";
            } else if (e instanceof LockedAccountException) {
                msg = "帐号已被锁住，请联系后台管理员解锁";
            } else if (e instanceof NoRoleException) {
                msg = "此账号未设置角色";
            } else {
                msg = "认证失败";
            }
            logger.info("-----------:"+msg);
            logger.info(e.getMessage());
        }
        if (rs.hasErrors())
        {
            for (ObjectError error : rs.getAllErrors())
            {
                System.out.println(error.getDefaultMessage());
            }
            return "hello";
        }
        return "hello";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(String username1,Model model){
        EurekaResponse eurekaResponse = adminFeignClient.findByUsername(username1);
        Admin admin = new Gson().fromJson(eurekaResponse.getValue(),Admin.class);
        if (admin!=null){
            model.addAttribute("flag",true);
            model.addAttribute("Admin",admin);
        }else {
            model.addAttribute("flag",false);
        }
        return "index";
    }
}
