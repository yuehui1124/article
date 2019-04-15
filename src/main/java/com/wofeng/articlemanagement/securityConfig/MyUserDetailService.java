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
    private SysRoleMenuMapper roleMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        SysUser user = new SysUser();
        user.setUsername(username);
        SysUser testUser =  this.userMapper.selectOne(user);
        if (testUser != null ){
            //查询用户身份,根据身份查询权限
            SysUserRole userRole = this.sysUserRoleMapper.selectOne(new SysUserRole(){{
                setUserId(getUserId());
            }});
            //查询role 对应的权限
            Example roleMenuExanmple = new Example(SysRoleMenu.class);
            roleMenuExanmple.createCriteria().andEqualTo("menuId",userRole.getRoleId());
            List<SysRoleMenu> roleMenus = roleMenuMapper.selectByExample(roleMenuExanmple);
            //迭代list

        }else {
            throw new UsernameNotFoundException("用户名不存在");
        }

        //随便创建一个用户. myusql 生成准备重新整合

        user.setPassword(this.passwordEncoder.encode("123456"));
        System.out.println(user.getPassword());
        return new User(username, user.getPassword(), true,
                true, true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
