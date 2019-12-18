package com.yao.service.service.admin;

import com.yao.core.entity.Admin;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public interface AdminService {
    Admin get(Long id);

    Admin findByUsername(String username);

    int update(Admin admin);
}
