package com.jvm.test10.java;

/**
 * 测试对象实例化的过程
 * 1.加载类元信息
 * 2.为对象分配内存
 * 3.处理并发问题
 * 4.属性的默认初始化（零值初始化）
 * 5.设置对象头信息
 * 6.属性的显示初始化 、代码块中初始化 、代码块中初始化
 *
 * 给对象的属性赋值的操作
 * ①属性的默认初始化  ②显示初始化 ③代码块中初始化 ④代码块中初始化
 */
public class Customer {

    int id =1001;//显示初始化
    String name;
    Account acct;
    {
        name="匿名用户";//代码块中初始化
    }

    public Customer( ) {
        acct = new Account();//代码块中初始化
    }
}
class Account{

}
