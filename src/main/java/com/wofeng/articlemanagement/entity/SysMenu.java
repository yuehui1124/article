package com.wofeng.articlemanagement.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 连接地址
     */
    private String url;

    /**
     * 1：第一级；2：第二级，以此类推
     */
    private Integer level;

    /**
     * 如果是第一级，父类ID为0；
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 0：不可用；1：可用
     */
    private Integer status;

    /**
     * 界面映射图标
     */
    private Date icon;

    /**
     * 排序
     */
    private Integer sorter;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 第一次创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @Column(name = "modify_user")
    private String modifyUser;

    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取菜单名
     *
     * @return name - 菜单名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名
     *
     * @param name 菜单名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取连接地址
     *
     * @return url - 连接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置连接地址
     *
     * @param url 连接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取1：第一级；2：第二级，以此类推
     *
     * @return level - 1：第一级；2：第二级，以此类推
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置1：第一级；2：第二级，以此类推
     *
     * @param level 1：第一级；2：第二级，以此类推
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取如果是第一级，父类ID为0；
     *
     * @return parent_id - 如果是第一级，父类ID为0；
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置如果是第一级，父类ID为0；
     *
     * @param parentId 如果是第一级，父类ID为0；
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取0：不可用；1：可用
     *
     * @return status - 0：不可用；1：可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：不可用；1：可用
     *
     * @param status 0：不可用；1：可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取界面映射图标
     *
     * @return icon - 界面映射图标
     */
    public Date getIcon() {
        return icon;
    }

    /**
     * 设置界面映射图标
     *
     * @param icon 界面映射图标
     */
    public void setIcon(Date icon) {
        this.icon = icon;
    }

    /**
     * 获取排序
     *
     * @return sorter - 排序
     */
    public Integer getSorter() {
        return sorter;
    }

    /**
     * 设置排序
     *
     * @param sorter 排序
     */
    public void setSorter(Integer sorter) {
        this.sorter = sorter;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取第一次创建时间
     *
     * @return create_time - 第一次创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置第一次创建时间
     *
     * @param createTime 第一次创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return modify_user - 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置修改人
     *
     * @param modifyUser 修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     * 获取更新时间
     *
     * @return modify_time - 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     *
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}