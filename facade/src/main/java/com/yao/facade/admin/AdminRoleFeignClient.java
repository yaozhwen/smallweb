package com.yao.facade.admin;

import com.yao.core.eureka.EurekaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yaozwsq on 2019/12/17 10:01.
 */
@FeignClient(name = "${feign.service.name}", path="/service/adminRole")
public interface AdminRoleFeignClient {

    @PostMapping("/findById")
    EurekaResponse findById(@RequestParam(value = "id", required = false) Long id);

}
