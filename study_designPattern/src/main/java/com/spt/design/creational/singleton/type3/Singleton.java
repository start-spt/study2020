package com.spt.design.creational.singleton.type3;

/**
 * 懒汉式，线程安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}