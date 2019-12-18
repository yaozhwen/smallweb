package com.yao.admin.web_admin.security;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yao.core.common.Constants;
import com.yao.core.entity.Admin;
import com.yao.core.entity.AdminRole;
import com.yao.core.entity.vo.AdminBean;
import com.yao.core.entity.vo.AdminPermissionVo;
import com.yao.core.eureka.EurekaResponse;
import com.yao.core.util.DateUtils;
import com.yao.facade.admin.AdminFeignClient;
import com.yao.facade.admin.AdminPermissionFeignClient;
import com.yao.facade.admin.AdminRoleFeignClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaozwsq on 2019/12/16 14:42.
 */
public class AuthenticationRealm extends AuthorizingRealm{
    @Resource
    private AdminFeignClient adminFeignClient;

    @Resource
    private AdminRoleFeignClient adminRoleFeignClient;

    @Resource
    private AdminPermissionFeignClient adminPermissionFeignClient;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        AdminBean adminBean = (AdminBean) principalCollection.getPrimaryPrincipal();
        if (adminBean != null) {
            // 从数据库中查找该用户的角色和权限
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            Set<String> permissions = new HashSet<String>();

            if(Constants.LOGIN_TYPE_ADMIN.equals(adminBean.getLoginType())){
                EurekaResponse eurekaResponse = adminFeignClient.findById(adminBean.getId());
                Admin admin = new Gson().fromJson(eurekaResponse.getValue(),Admin.class);
                EurekaResponse eurekaResponse1 = adminPermissionFeignClient.findByRoleId(admin.getRoleId());

                List<AdminPermissionVo> list = new Gson().fromJson(eurekaResponse1.getValue(),new TypeToken<List<AdminPermissionVo>>(){}.getType());
                for(AdminPermissionVo adminPermissionVo :list){
                    if(StringUtils.isNotBlank(adminPermissionVo.getPermission())){
                        permissions.add(adminPermissionVo.getPermission());
                    }
                }
            }

            authorizationInfo.setStringPermissions(permissions);
            return authorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        com.yao.admin.web_admin.security.AuthenticationToken authenticationToken = (com.yao.admin.web_admin.security.AuthenticationToken)token;
        String loginType = authenticationToken.getLoginType();
        if ("admin".equals(loginType)){
            String captcha = authenticationToken.getCaptcha();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            String c = (String) request.getSession().getAttribute(Constants.ADMIN_SESSION_CAPTCHA);
//            if(StringUtils.isBlank(c) || !c.equalsIgnoreCase(captcha)){
//                throw new IncorrectCaptchaException();
//            }
            if(!Constants.LOGIN_TYPE_ADMIN.equals(loginType)){
                throw new UnknownAccountException();
            }
            String username = authenticationToken.getUsername();

            EurekaResponse eurekaResponse = adminFeignClient.findByUsername(username);
            Admin admin = new Gson().fromJson(eurekaResponse.getValue(),Admin.class);
            if(admin==null){
                throw new UnknownAccountException();
            }
            if (admin.getStatus()!=1) {
                throw new DisabledAccountException();
            }

            String password = new String(authenticationToken.getPassword());
            String pass = admin.getPwd();

            if(!pass.equals(password)){
                Integer failCount = admin.getLoginFailureCount();
                if(failCount==null){
                    failCount = 0;
                }
                failCount++;
                admin.setLoginFailureCount(failCount);
                if(failCount>=5){
                    admin.setLockedOrNo(true);
                }else{
                    admin.setLockedOrNo(false);
                }
                admin.setLockedDate(new Date());
                adminFeignClient.update(admin);
                if(admin.getLockedOrNo()){
                    throw new LockedAccountException();
                }else {
                    throw new IncorrectCredentialsException();
                }
            }

            EurekaResponse eurekaResponse1 = adminRoleFeignClient.findById(admin.getRoleId());
            AdminRole adminRole = new Gson().fromJson(eurekaResponse1.getValue(),AdminRole.class);
            if (adminRole==null){
                throw new NoRoleException();
            }

            if(admin.getLockedOrNo()){
                if(admin.getLoginFailureCount()>=5){
                    Date unlockDate = DateUtils.addMinutes(admin.getLockedDate(), 30);
                    if (new Date().after(unlockDate)) {
                        admin.setLoginFailureCount(0);
                        admin.setLockedOrNo(false);
                        admin.setLockedDate(null);
                        admin.setLoginDate(new Date());
                        EurekaResponse eurekaResponse2 = adminFeignClient.update(admin);
                    } else {
                        throw new LockedAccountException();
                    }
                }else{
                    admin.setLoginFailureCount(0);
                    admin.setLockedOrNo(false);
                    admin.setLockedDate(null);
                    admin.setLoginDate(new Date());
                    EurekaResponse eurekaResponse2 = adminFeignClient.update(admin);
                }
            }else{
                admin.setLoginFailureCount(0);
                admin.setLockedOrNo(false);
                admin.setLockedDate(null);
                admin.setLoginDate(new Date());
                EurekaResponse eurekaResponse2 = adminFeignClient.update(admin);
            }

            AdminBean adminBean = new AdminBean();
            adminBean.setId(admin.getId());
            adminBean.setUsername(admin.getUsername());
            adminBean.setLoginType(loginType);
            adminBean.setName(admin.getName());
            Date d = DateUtils.getDateNoSSS(admin.getLoginDate());
            adminBean.setLoginDate(d);
            adminBean.setPhone(admin.getPhone());
            adminBean.setRoleId(admin.getRoleId());
            adminBean.setRoleName(adminRole.getName());
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute(Constants.ADMIN_SESSION_BEAN,adminBean);

            return new SimpleAuthenticationInfo(adminBean, password, adminBean.getUsername());
        }else {
            throw new AuthenticationException();
        }
    }
}
