package com.jvm.test2.java2;

/**
 * 测试 -XX:UseTLAB 参数，默认是开启的
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("我是打酱油的。。。");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
