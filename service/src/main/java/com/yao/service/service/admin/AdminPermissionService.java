package com.yao.service.service.admin;

import com.yao.core.entity.vo.AdminPermissionVo;

import java.util.List;

/**
 * Created by yaozwsq on 2019/12/17 11:16.
 */
public interface AdminPermissionService {

    List<AdminPermissionVo> findByRoleId(Long rid);

}
