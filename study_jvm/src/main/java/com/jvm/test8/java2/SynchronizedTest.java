package com.jvm.test8.java2;

/**
 * 同步省略说明
 */
public class SynchronizedTest {
    public void f() {
        Object hollis = new Object();
        synchronized (hollis){
            System.out.println(hollis);
        }

    }
}
