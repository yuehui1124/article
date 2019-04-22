package com.wofeng.articlemanagement.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_student")
public class TestStudent implements Serializable {
    @Id
    private Integer id;

    /**
     * 测试表名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

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
     * 获取测试表名称
     *
     * @return name - 测试表名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置测试表名称
     *
     * @param name 测试表名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}