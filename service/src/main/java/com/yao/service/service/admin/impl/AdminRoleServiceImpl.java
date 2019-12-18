package com.yao.service.service.admin.impl;

import com.yao.core.entity.AdminRole;
import com.yao.service.dao.admin.AdminRoleDao;
import com.yao.service.service.admin.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yaozwsq on 2019/12/17 10:07.
 */
@Transactional(readOnly = true)
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public AdminRole get(Long id) {
        return adminRoleDao.get(id);
    }

}
