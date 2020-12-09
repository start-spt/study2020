package com.spt.design.creational.singleton.type5;

/**
 * 登记式/静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 *
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程
 */
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
        /**
         * final变量:
         * 如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
         * 如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
         *
         * Java语言提供了八种基本类型。
         * 四个整数型:
         *      byte 数据类型是8位、有符号的，以二进制补码表示的整数
         *      short 数据类型是 16 位、有符号的以二进制补码表示的整数
         *      int 数据类型是32位、有符号的以二进制补码表示的整数
         *      long 数据类型是 64 位、有符号的以二进制补码表示的整数
         * 两个浮点型:
         *      float 数据类型是单精度、32位、符合IEEE 754标准的浮点数
         *      double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数
         * 一种字符类型:
         *      char类型是一个单一的 16 位 Unicode 字符
         * 一种布尔型:
         *      boolean数据类型表示一位的信息
         */

    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}