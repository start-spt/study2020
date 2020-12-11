package com.spt.test.mybatisplus.service;
/**
 * Created by ${HeJD} on 2018/6/27.
 */
public interface AccountService {
    /**
     * 转账
     * @param fromUserId
     * @param toUserId
     * @param account
     */
    public void transferAccounts(int fromUserId,int toUserId,float account);
}