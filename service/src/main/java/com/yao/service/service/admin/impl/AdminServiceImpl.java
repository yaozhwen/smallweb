package com.yao.service.service.admin.impl;

import com.yao.core.entity.Admin;
import com.yao.service.dao.admin.AdminDao;
import com.yao.service.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yaozwsq on 2019/12/4.
 */
@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin get(Long id) {
        return adminDao.get(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDao.findByUsername(username);
    }

    @Override
    public int update(Admin admin) {
        return adminDao.update(admin);
    }
}
