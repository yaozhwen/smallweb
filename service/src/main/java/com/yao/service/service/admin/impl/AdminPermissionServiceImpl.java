package com.yao.service.service.admin.impl;

import com.yao.core.entity.vo.AdminPermissionVo;
import com.yao.service.dao.admin.AdminPermissionDao;
import com.yao.service.service.admin.AdminPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yaozwsq on 2019/12/17 11:20.
 */
@Transactional(readOnly = true)
@Service("adminPermissionService")
public class AdminPermissionServiceImpl implements AdminPermissionService {

    @Autowired
    private AdminPermissionDao adminPermissionDao;

    @Override
    public List<AdminPermissionVo> findByRoleId(Long rid) {
        return adminPermissionDao.findByRoleId(rid);
    }
}
