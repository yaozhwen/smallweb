package com.yao.admin.web_admin.controller;

import com.yao.core.util.DateEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * Created by yaozwsq on 2019/12/5.
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class,new DateEditor(true));
    }
}
