package com.wofeng.articlemanagement.securityConfig;

import com.wofeng.articlemanagement.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author yueyueyue
 * @date 2019/4/17 18:23
 * Description: article-management
 */
@Data
public class MyUserDetail implements UserDetails {

    private SysUser user;
    /**
     * 登录帐号
     */
    private String username;

    /**
     * 身份
     */
    private String role;

    /**
     * 目录
     */
    private String menu;


    MyUserDetail(SysUser user, String role, String menu) {
        this.user = user;

        this.role = role;

        this.username = user.getUsername();

        this.menu = menu;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(role.toString());
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
