package com.wofeng.articlemanagement.entity;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    private Integer id;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 1:有效，0:禁止登录
     */
    private Integer status;

    /**
     * 父角色ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色代码
     *
     * @return code - 角色代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置角色代码
     *
     * @param code 角色代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取1:有效，0:禁止登录
     *
     * @return status - 1:有效，0:禁止登录
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1:有效，0:禁止登录
     *
     * @param status 1:有效，0:禁止登录
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取父角色ID
     *
     * @return parent_id - 父角色ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父角色ID
     *
     * @param parentId 父角色ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}