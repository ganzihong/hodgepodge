package com.ganzihong.hodgepodge.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author ganzh
 * @description
 * @date 2019/1/13
 */
public class User {
    private Integer id;
    private String name;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
