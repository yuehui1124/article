package com.wofeng.articlemanagement.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * userrole中间表
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-15
 */
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户id
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", userId=" + userId +
        "}";
    }
}
