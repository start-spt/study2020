package com.jvm.test2.java1;

/**
 * -Xms 用来设置堆空间(年轻代+老年代)的初始内存大小
 *
 * 手动设置:-Xms600m -Xmx600m
 * 开发中建议将初始堆内存和最大的堆内存设置成相同的值
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        //返回java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms :" + initialMemory);
        System.out.println("-Xmx :" + maxMemory);

//        System.out.println("系统内存大小为：" + initialMemory * 64 / 1024 + "G");
//        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
