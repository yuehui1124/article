package com.wofeng.articlemanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author yueyueyue
 * @since 2019-04-15
 */
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private String createUser;

    /**
     * 第一次创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 更新时间
     */
    private Date modifyTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getIcon() {
        return icon;
    }

    public void setIcon(Date icon) {
        this.icon = icon;
    }

    public Integer getSorter() {
        return sorter;
    }

    public void setSorter(Integer sorter) {
        this.sorter = sorter;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
        "id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", level=" + level +
        ", parentId=" + parentId +
        ", status=" + status +
        ", icon=" + icon +
        ", sorter=" + sorter +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
