package com.wofeng.articlemanagement.securityConfig;


import com.wofeng.articlemanagement.entity.SysRoleMenu;
import com.wofeng.articlemanagement.entity.SysUser;
import com.wofeng.articlemanagement.entity.SysUserRole;
import com.wofeng.articlemanagement.mapper.SysRoleMenuMapper;
import com.wofeng.articlemanagement.mapper.SysUserMapper;
import com.wofeng.articlemanagement.mapper.SysUserRoleMapper;
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

    /**
     * 登录
     * @param username 用户名称
     * @return userDetails
     * @throws UsernameNotFoundException 用户不存在
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        if(username == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        try {
            SysUser user =  this.userMapper.selectOne(new SysUser() {{
                setUsername(username);
            }});
            if (user != null) {
                Example roleExample = new Example(SysUserRole.class);
                roleExample.createCriteria().andEqualTo("userId",user.getId());
                //查出所有角色ID
                List<SysUserRole> userRoles = this.sysUserRoleMapper.selectByExample(roleExample);
                if (userRoles.size() > 0) {
                    List<Integer> roleIds = new ArrayList<>();
                    for (SysUserRole userRole : userRoles){
                        roleIds.add(userRole.getRoleId());
                    }
                    //查出中间表
                    Example roleMenuExample = new Example(SysRoleMenu.class);
                    roleMenuExample.createCriteria().andIn("roleId",roleIds);
                    List<SysRoleMenu> roleMenus = this.sysRoleMenuMapper.selectByExample(roleMenuExample);
                    if (roleMenus.size() > 0) {
                        List<Integer> menuIds = new ArrayList<>();
                        for (SysRoleMenu sysRoleMenu : roleMenus) {
                            menuIds.add(sysRoleMenu.getMenuId());
                        }
                        //根据menuID查出所有菜单
                        userDetails = new MyUserDetail(user,roleIds,menuIds);
                    }else {
                        log.error("该用户没有菜单,{}",user.getUsername());
                    }
                } else {
                    log.error("该用户没有角色,{}",user.getUsername());
                }
            }else {
                throw new UsernameNotFoundException("用户名不存在");
            }
        }catch (Exception e) {
            log.error("查询用户失败, 帐号 {}，{}", username, e.getMessage());
        }
        return userDetails;

        /*return new User(username, user.getPassword(), true,
                true, true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList(role.toString()));*/
    }


}
