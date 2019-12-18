package com.yao.facade.admin;

import com.yao.core.eureka.EurekaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yaozwsq on 2019/12/17 11:32.
 */
@FeignClient(name = "${feign.service.name}", path="/service/adminPermission")
public interface AdminPermissionFeignClient {

    @PostMapping("/findByRoleId")
    EurekaResponse findByRoleId(@RequestParam(value = "rid", required = false) Long rid);

}
