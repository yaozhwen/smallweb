package com.yao.service.dao.admin;

import com.yao.core.entity.vo.AdminPermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yaozwsq on 2019/12/17 11:17.
 */
public interface AdminPermissionDao {

    List<AdminPermissionVo> findByRoleId(@Param("rid") Long rid);
}
