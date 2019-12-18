package com.yao.service.eureka.admin;

import com.google.gson.Gson;
import com.yao.core.common.BaseLog;
import com.yao.core.entity.AdminRole;
import com.yao.core.eureka.EurekaResponse;
import com.yao.service.service.admin.AdminRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yaozwsq on 2019/12/18 10:19.
 */
@RestController
@RequestMapping(value = "/service/adminRole")
public class AdminRoleEureka extends BaseLog {
    @Resource
    private AdminRoleService adminRoleService;

    @PostMapping("/findById")
    public EurekaResponse findById(@RequestParam(value = "id", required = false) Long id) {
        EurekaResponse eurekaResponse = null;
        AdminRole adminRole = adminRoleService.get(id);
        eurekaResponse = new EurekaResponse(EurekaResponse.Status.success, "88", "success");
        String value = new Gson().toJson(adminRole);
        eurekaResponse.setValue(value);
        return eurekaResponse;
    }

}
