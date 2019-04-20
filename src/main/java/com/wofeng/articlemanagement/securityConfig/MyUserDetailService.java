package com.wofeng.articlemanagement.securityConfig;


import com.wofeng.articlemanagement.entity.SysRoleMenu;
import com.wofeng.articlemanagement.entity.SysUser;
import com.wofeng.articlemanagement.entity.SysUserRole;
import com.wofeng.articlemanagement.mapper.SysRoleMenuMapper;
import com.wofeng.articlemanagement.mapper.SysUserMapper;
import com.wofeng.articlemanagement.mapper.SysUserRoleMapper;
import com.wofeng.articlemanagement.service.impl.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/15 11:42
 * Description: article-management
 */
@Slf4j
@Service
@Configuration
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SystemService systemService;

    /**
     * 登录
     *
     * @param username 用户名称
     * @return userDetails
     * @throws UsernameNotFoundException 用户不存在
     */
    @Override
    public MyUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetail userDetails = null;
        if (username == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        try {
            SysUser user = this.userMapper.selectOne(new SysUser() {{
                setUsername(username);
            }});
            if (user != null) {
                Example roleExample = new Example(SysUserRole.class);
                roleExample.createCriteria().andEqualTo("userId", user.getId());
                //查出所有角色ID
                List<SysUserRole> userRoles = this.sysUserRoleMapper.selectByExample(roleExample);
                if (userRoles.size() > 0) {
                    List<Integer> roleIdList = new ArrayList<>();
                    for (SysUserRole userRole : userRoles) {
                        roleIdList.add(userRole.getRoleId());
                    }
                    StringBuffer roleIds = new StringBuffer();
                    for (int i = 0 ;i < roleIdList.size(); i++){
                        if (i == 0) {
                            roleIds.append(roleIdList.get(i));
                        } else {
                            roleIds.append("," + roleIdList.get(i));
                        }
                    }
                    //查出中间表
                    Example roleMenuExample = new Example(SysRoleMenu.class);
                    roleMenuExample.createCriteria().andIn("roleId", roleIdList);
                    List<SysRoleMenu> roleMenus = this.sysRoleMenuMapper.selectByExample(roleMenuExample);
                    if (roleMenus.size() > 0) {
                        StringBuffer menuIds = new StringBuffer();
                        for (int i = 0; i < roleMenus.size(); i++) {
                            if (i == 0) {
                                menuIds.append(roleMenus.get(i).getMenuId());
                            } else {
                                menuIds.append("," + roleMenus.get(i).getMenuId());
                            }
                        }

                        System.out.println("menuIds:" + menuIds.toString());


                        userDetails = new MyUserDetail(user,roleIds.toString(), this.systemService.getMenus(menuIds.toString()).getData());
                    } else {
                        log.error("该用户没有菜单,{}", user.getUsername());
                    }
                } else {
                    log.error("该用户没有角色,{}", user.getUsername());
                }
            } else {
                throw new UsernameNotFoundException("用户名不存在");
            }
        } catch (Exception e) {
            log.error("查询用户失败, 帐号 {}，{}", username, e.getMessage());
        }
        return userDetails;

    }


}
