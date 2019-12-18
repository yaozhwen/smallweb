package com.yao.facade.admin;

import com.yao.core.entity.Admin;
import com.yao.core.eureka.EurekaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yaozwsq on 2019/12/5.
 */
@FeignClient(name = "${feign.service.name}",path = "/service/admin")
public interface AdminFeignClient {

    @PostMapping("/findById")
    EurekaResponse findById(@RequestParam(value = "id",required = false) Long id);

    @PostMapping("/findByUsername")
    EurekaResponse findByUsername(@RequestParam(value = "username", required = false) String username);

    @PostMapping("/update")
    EurekaResponse update(@RequestBody Admin admin);

}
