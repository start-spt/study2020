package com.spt.design.creational.singleton.type1;

/**
 *   单例模式适用场景：
 *   1）需要频繁实例化然后销毁的对象。
 *   2）创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
 *   3）有状态的工具类对象。
 *         -频繁访问数据库或文件的对象。
 *
 *   多线程的线程池的设计一般也是采用单例模式
 *   数据库连接池的设计一般也是采用单例模式
 *
 *
 *
 * 饿汉式
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 它基于 classloader 机制避免了多线程的同步问题
 */
public class SingleObject {

    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject() {
    }

    //获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}