package com.spt.test.mybatisplus.service.impl;

import com.spt.test.mybatisplus.entity.Account;
import com.spt.test.mybatisplus.mapper.AccountMapper;
import com.spt.test.mybatisplus.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by ${HeJD} on 2018/6/27.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Transactional
    public void transferAccounts(int fromUserId, int toUserId, float account) {
        Account fromUserAccount = accountMapper.getOneAccount(fromUserId);
        fromUserAccount.setBalance(fromUserAccount.getBalance() - account);
        accountMapper.save(fromUserAccount); // fromUser扣钱
        Account toUserAccount = accountMapper.getOneAccount(toUserId);
        toUserAccount.setBalance(toUserAccount.getBalance() + account);
        //假设转账的时候假如出现异常，业务类或业务方法中没有使用@Transactional控制事务，则会出现钱转出了，收钱人没有收到的情况
        int zero = 1 / 0;  //这里我们先把这个异常注释掉，稍后我们再打开
        accountMapper.save(toUserAccount); // toUser加钱
    }
}