package com.yao.service.eureka.admin;

import com.google.gson.Gson;
import com.yao.core.common.BaseLog;
import com.yao.core.entity.Admin;
import com.yao.core.eureka.EurekaResponse;
import com.yao.service.service.admin.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yaozwsq on 2019/12/4.
 */
@RestController
@RequestMapping(value = "/service/admin")
public class AdminEureka extends BaseLog{

    @Resource
    private AdminService adminService;

    @PostMapping("/findById")
    public EurekaResponse findById(@RequestParam(value = "id", required = false) Long id) {
        EurekaResponse eurekaResponse = null;
        Admin admin = adminService.get(id);
        eurekaResponse = new EurekaResponse(EurekaResponse.Status.success, "88", "success");
        String value = new Gson().toJson(admin);
        eurekaResponse.setValue(value);
        return eurekaResponse;
    }
}
