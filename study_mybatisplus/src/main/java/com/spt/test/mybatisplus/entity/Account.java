package com.spt.test.mybatisplus.entity;

import lombok.Data;

@Data
public class Account {
    /**
     * id 编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 余额
     */
    private float balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}