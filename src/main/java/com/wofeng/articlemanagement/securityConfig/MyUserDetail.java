package com.wofeng.articlemanagement.securityConfig;

import com.wofeng.articlemanagement.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/17 18:23
 * Description: article-management
 */
public class MyUserDetail implements UserDetails, Serializable {

    private SysUser user;
    /**
     * 登录帐号
     */
    private String username;

    /**
     * 身份
     */
    private List<Integer> roles;

    /**
     * 目录
     */
    private List<Integer> menus;


    MyUserDetail(SysUser user, List<Integer> role, List<Integer> menu) {
        this.user = user;

        this.roles = role;

        this.username = user.getUsername();



        this.menus = menu;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    /**
     * 帐户未过期
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 帐户非锁定
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 证书未过期
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
