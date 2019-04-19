package com.wofeng.articlemanagement.entity;

import javax.persistence.*;

@Table(name = "test_student")
public class TestStudent {
    @Id
    private Integer id;

    /**
     * 测试表名称
     */
    private String name;

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
}