package com.yao.admin.web_admin.controller;

import com.yao.core.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaozwsq on 2019/12/5.
 */
@Controller
//@RequestMapping(value = "/thymeleaf")
public class LoginController extends BaseController {

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        logger.info("login-index");
        /*request.getSession().removeAttribute(Constants.ADMIN_SESSION_BEAN);

        Subject subject = SecurityUtils.getSubject();
        if (subject!=null){
            subject.logout();
        }*/
        model.addAttribute("name","Dear");
        return "hello";
    }
}
