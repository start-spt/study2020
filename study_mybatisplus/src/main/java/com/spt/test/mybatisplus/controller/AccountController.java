package com.spt.test.mybatisplus.controller;

import com.spt.test.mybatisplus.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by ${HeJD} on 2018/6/27.
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/transfer")
    public String transferAccounts() {
        try {
            //1号zhsnasan  给2号lisi 转账200元
            accountService.transferAccounts(1, 2, 200);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "no";
        }
    }
}