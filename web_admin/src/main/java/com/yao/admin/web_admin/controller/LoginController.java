package com.yao.admin.web_admin.controller;

import com.yao.core.common.Constants;
import com.yao.core.entity.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaozwsq on 2019/12/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController extends BaseController {

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
    public String add(Model model, @Validated Admin admin, BindingResult rs){
        logger.info("login-add");
        model.addAttribute("userInfo",admin);
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
}
